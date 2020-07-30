package top;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 有效的括号
 */
public class ValidParentheses {

    /*分析需要使用递归方式,建模为属性结构,从叶子结点遍历到根结点*/

    public static void main(String[] args) {
        System.out.println(isValid("({){}}"));
    }

    public static boolean isValid(String s) {
        while (s != null && !"".equals(s)) {
            String tmp = s;
            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
            if (tmp == s){
                break;
            }
        }
        if ("".equals(s) || s == null){
            return true;
        }
        return false;
    }
}
