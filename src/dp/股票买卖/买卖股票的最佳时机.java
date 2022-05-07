package dp.股票买卖;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class 买卖股票的最佳时机 {


    public int maxProfit(int[] prices) {
        /** 0代表没有持有股票，1代表持有股票 */
        int[][] dp = new int[prices.length][2];
        /**初始化dp表 */
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for(int i = 1; i < prices.length; i++){
            /**没有股票：之前就没有这次不买，之前有这次卖掉了 */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            /**持有股票：之前有这次不卖，之前没有这次买 */
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 压缩dp表后的算法
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        /**未持有的最大收益和持有的最大收益 */
        int notHold = 0;
        int hold = -prices[0];
        for(int i = 1; i < prices.length; i++){
            /**没有股票：之前就没有这次不买，之前有这次卖掉了 */
            notHold = Math.max(notHold, hold + prices[i]);
            /**持有股票：之前有这次不卖，之前没有这次买 */
            hold = Math.max(hold, - prices[i]);
        }
        return notHold;
    }
}
