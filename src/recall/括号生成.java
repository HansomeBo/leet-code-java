package recall;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * <p>
 * 要记住括号的两个合法校验规则
 * 任意位置左括号数量大于右括号数量
 * 最后左括号数量等于右括号数量
 */
public class 括号生成 {

    private List<String> res = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        generateParenthesisBackTrack(n, n, "");
        return res;
    }

    public void generateParenthesisBackTrack(int left, int right, String s) {
        if (left < 0 || right < 0) return;
        if (left > right) return;
        if (left == right && left == 0) {
            res.add(s);
            return;
        }
        generateParenthesisBackTrack(left - 1, right, s + "(");
        generateParenthesisBackTrack(left, right - 1, s + ")");
    }
}
