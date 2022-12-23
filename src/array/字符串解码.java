package array;

/**
 * https://leetcode.cn/problems/decode-string/
 * <p>
 * 3[a2[cccc4[b]]]
 */
public class 字符串解码 {


    public String decodeString(String s) {
        int bracketsCount = 0;/*括号计数，左括号加一，右括号减一*/
        int count = 0;/*重复数*/
        int leftIndex = 0;
        boolean stopDfs = true;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                bracketsCount++;
                if (bracketsCount == 1) {
                    count = parseNum(s, i - 1);
                    leftIndex = i;
                } else {
                    stopDfs = false;
                }
            } else if (c == ']') {
                bracketsCount--;
                if (bracketsCount == 0) {
                    for (int j = 0; j < count; j++) {
                        result.append(s.substring(leftIndex + 1, i));
                    }
                    count = 0;
                    bracketsCount = 0;
                    leftIndex = 0;
                }
            } else if (bracketsCount == 0 && (c < '0' || c > '9')) {
                result.append(c);
            }
        }
        if (stopDfs) return result.toString();
        return decodeString(result.toString());
    }


    public int parseNum(String s, int index) {
        int num = 0;
        int p = 0;
        while (index >= 0 && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            num += (s.charAt(index--) - '0') * Math.pow(10, p++);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new 字符串解码().decodeString("100[leetcode]"));
    }
}
