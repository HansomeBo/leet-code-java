package util;

public class NumberUtil {

    /**
     * 十进制转二进制
     *
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
     *
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

    /**
     * 其他进制转十进制
     *
     * @param number
     * @return
     */
    public static int scale2Decimal(String number, int scale) {
        if (2 > scale || scale > 32) {
            throw new IllegalArgumentException("scale is not in range");
        }
        // 不同其他进制转十进制,修改这里即可
        int total = 0;
        String[] ch = number.split("");
        int chLength = ch.length;
        for (int i = 0; i < chLength; i++) {
            total += Integer.valueOf(ch[i]) * Math.pow(scale, chLength - 1 - i);
        }
        return total;

    }

    /**
     * 十进制转其他进制
     *
     * @param number
     * @param scale
     * @return
     */
    public static String decimal2Scale(int number, int scale) {
        if (2 > scale || scale > 32) {
            throw new IllegalArgumentException("scale is not in range");
        }
        String result = "";
        while (0 != number) {
            result = number % scale + result;
            number = number / scale;
        }

        return result;
    }


}
