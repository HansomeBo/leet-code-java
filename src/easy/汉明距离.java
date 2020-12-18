package easy;

import util.NumberUtil;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class 汉明距离 {

    public static int hammingDistance(int x, int y) {
        String binaryx = NumberUtil.decimalToBinary(x);
        String binaryy = NumberUtil.decimalToBinary(y);
        int hamming = 0;
        int i = binaryx.length() - 1;
        int j = binaryy.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                if ('1' == binaryy.charAt(j--)) hamming++;
            } else if (j < 0) {
                if ('1' == binaryx.charAt(i--)) hamming++;
            } else if (binaryx.charAt(i--) != binaryy.charAt(j--)) hamming++;
        }
        return hamming;
    }

    public static int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static int hammingDistance3(int x, int y) {
        int n = x ^ y;
        int hanming = 0;
        while (n > 0) {
            if (n % 2 == 1) hanming++;
            n = n / 2;
        }
        return hanming;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(9, 4));
        System.out.println(hammingDistance2(9, 4));
        System.out.println(hammingDistance3(9, 4));
    }


}
