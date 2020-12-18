package util;

public class NumberUtil {

    /**
     * 十进制转二进制
     * @param n
     * @return
     */
    public static String decimalToBinary(int n) {
        String result = "";
        while (n > 0) {
            result = n % 2 + result;
            n = n / 2;
        }
        return result;
    }

    /**
     * 二进制转十进制
     * @param b
     * @return
     */
    public static int binaryTodecimal(String b) {
        int result = 0;
        int length = b.length();
        for (int i = 0; i < length; i++) {
            if ('1' == b.charAt(i)) result += Math.pow(2, length - i - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(789));
        System.out.println(binaryTodecimal("1100010101"));
    }


}
