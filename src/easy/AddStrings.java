package easy;

/**
 * 字符串相加
 * https://leetcode-cn.com/problems/add-strings/
 */
public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("18", "234"));
    }

    public static String addStrings(String number1, String number2) {
        int i = number1.length() - 1, j = number2.length() - 1, pop = 0;
        String res = "";
        while (i >= 0 || j >= 0 || pop > 0) {
            int n1 = 0, n2 = 0;
            if (i >= 0) {
                n1 = number1.charAt(i--) - '0';
            }
            if (j >= 0) {
                n2 = number2.charAt(j--) - '0';
            }

            int n = n1 + n2 + pop;
            pop = n / 10;
            res = n % 10 + res;
        }
        return res;
    }

}
