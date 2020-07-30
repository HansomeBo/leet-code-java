package top;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 * 递归,规律抽象
 */
public class CountAndSay {

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println("i:" + i + ":" + countAndSay(i));
        }
    }

    public static String countAndSay(int n) {
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuffer result = new StringBuffer();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; ) {
            if ((i + 2) < array.length && array[i] == array[i + 1] && array[i + 1] == array[i + 2]) {
                result.append("3" + array[i]);
                i = i + 3;
            }else if ((i + 1) < array.length && array[i] == array[i + 1] ) {
                result.append("2" + array[i]);
                i = i + 2;
            }else {
                result.append("1" + array[i]);
                i = i + 1;
            }
        }
        return result.toString();
    }
}
