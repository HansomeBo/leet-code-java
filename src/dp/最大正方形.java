package dp;

import util.PrintUtil;

/**
 * https://leetcode.cn/problems/maximal-square/
 * 动态规划，有技巧。dp表要设置的好。
 */
public class 最大正方形 {

    public static void main(String[] args) {
        new 最大正方形().maximalSquare(new char[][]{{'0', '1'}, {'1', '0'}});
    }

    /**
     * 动态规划
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        /*在x,y为右下角的正方型的最大边长*/
        int[][] dp = new int[matrix.length][matrix[0].length];
        /*
         * 动态转移方程
         * matrix[i][j] == '0' ： dp[i][j] = 0
         * matrix[i][j] == '1' ： dp[i][j] = min(dp[i - 1][j],dp[i,j - 1],dp[i - 1][j - 1]) + 1
         *
         * */
        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                maxLength = Math.max(dp[i][j], maxLength);
            }
        }
        PrintUtil.printIntArray(dp);
        return maxLength * maxLength;
    }
}
