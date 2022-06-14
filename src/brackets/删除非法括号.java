package brackets;

import java.util.HashSet;

/**
 * 字节面试的题
 * 给定一个包含非法括号的字符串，"(d())()"
 * 1、删除非法括号后结果括号正确，求一个结果
 * 2、删除非法括号后结果括号正确，求所有结果
 * 2、删除非法括号后结果括号正确，求最少操作的结果
 */
public class 删除非法括号 {

    HashSet<String> res = new HashSet<>();

    public HashSet<String> deleteInvailedBrackets(String s) {
        backTracing(s, "", 0, 0, 0);
        return res;
    }

    public void backTracing(String s, String tracingString, int left, int right, int index) {
        if (index == s.length() && left == right && !"".equals(tracingString))
            res.add(tracingString);
        if (index >= s.length())
            return;
        if (right > left)
            return;

        if ('(' == s.charAt(index)) {
            backTracing(s, tracingString + "(", left + 1, right, index + 1);
            backTracing(s, tracingString, left, right, index + 1);
        } else if (')' == s.charAt(index)) {
            backTracing(s, tracingString + ")", left, right + 1, index + 1);
            backTracing(s, tracingString, left, right, index + 1);
        } else if (!"".equals(tracingString)) {
            backTracing(s, tracingString + s.charAt(index), left, right, index + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 删除非法括号().deleteInvailedBrackets("(a())"));
    }
}
