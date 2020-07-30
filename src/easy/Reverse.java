package easy;

/*https://leetcode-cn.com/problems/reverse-integer/
整数反转
*/
public class Reverse {

    public static void main(String[] args) {
        /*整数的反转主要考虑反转后的数值溢出问题,在最大值前一位进行溢出判断
        * 原数值进行每次取最小位并进行数值的缩进
        *
        * 又没有什么办法取整数的长度
        * */
        System.out.println(reverseString(120));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static int reverseString(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }
            res = res * 10 + pop;
            x = x / 10;
        }
        return res;
    }
}
