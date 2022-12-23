package dp;

/**
 * https://leetcode.cn/problems/perfect-squares/
 */
public class 完全平方数 {

    /**
     * 动态转移方程 dp[i] = min(dp[i - j^2]) + 1
     * j^2 : 0 ~ i 遍历
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minSquares = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minSquares = Math.min(minSquares, dp[i - j * j]);
            }
            dp[i] = minSquares + 1;
        }
        return dp[n];
    }
}
