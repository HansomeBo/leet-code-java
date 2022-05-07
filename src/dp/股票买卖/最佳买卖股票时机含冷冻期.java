package dp.股票买卖;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class 最佳买卖股票时机含冷冻期 {

    public int maxProfit(int[] prices) {
        /** 0代表没有持有股票，1代表持有股票 */
        int[][] dp = new int[prices.length][2];
        /**初始化dp表 */
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for(int i = 1; i < prices.length; i++){
            /**没有股票：之前就没有这次不买，之前有这次卖掉了 */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            /**持有股票：之前有这次不卖，之前没有这次买 ,买入需要隔一天以上*/
            if(i >= 2){
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }else{
                dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
            }
        }
        return dp[prices.length - 1][0];
    }

}
