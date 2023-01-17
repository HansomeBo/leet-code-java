package string;

/**
 * https://leetcode.cn/problems/string-to-integer-atoi
 *
 * 这题边界条件有点多，使用有限状态机（deterministic finite automaton, DFA）可以优雅的解这道题
 *
 * "+-12"
 */
public class 字符串转换整数 {

    /**
     * 比较臃肿的写法，写各种判断
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        boolean isNagetive = false;
        if (s.charAt(0) == '-') {
            s = s.replaceFirst("-", "");
            isNagetive = true;
        }else if (s.charAt(0) == '+') {
            s = s.replaceFirst("\\+", "");
        }
        if (s.length() == 0) return 0;
        if(s.charAt(0) < '0' || s.charAt(0) > '9') return 0;
        Long result = 0L;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num < 0 || num > 9) break;
            result *= 10;
            if(isNagetive){
                result -= num;
            }else{
                result += num;
            }
            if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return result.intValue();
    }
}
