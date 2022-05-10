package dp.easy;

import java.util.List;

/**
 * https://leetcode.cn/problems/counting-bits/
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOneBits(i);
        }
        return res;
    }

    /**
     * 动态规划
     * 
     * @param n
     * @return
     */
    public int[] countBitsII(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[(i & (i - 1))] + 1;
        }
        return res;
    }

    /**
     * 计算一个整数的二进制中有多少个1
     * n & (n - 1) 该运算将二进制表示的最后一个1变成0
     * 
     * @param n
     * @return
     */
    public int countOneBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
