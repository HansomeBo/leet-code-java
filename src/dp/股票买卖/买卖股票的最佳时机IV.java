package dp.股票买卖;

import util.PrintUtil;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class 买卖股票的最佳时机IV {

    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            System.out.println("-------当前数值：" + prices[i]);
            /*第一个节点和第一次买入单独定义*/
            for (int j = 0; j <= k; j++) {
                /*第一个节点的定义*/
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                /*第1茨买入还没卖出，最大收益为 -prices[i]*/
                if (j == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Math.max(dp[i - 1][0][1], -prices[i]);
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                System.out.println("未持有:" + dp[i][j][0] + ", " + dp[i - 1][j][0] + ", " + dp[i - 1][j - 1][1] + ", " + prices[i]);

                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                System.out.println("持有:" + dp[i][j][1] + ", " + dp[i - 1][j][1] + ", " + dp[i - 1][j][0] + ", " + prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2, 1, 4, 5, 2, 9, 7}));
    }
}
