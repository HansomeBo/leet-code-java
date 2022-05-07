package dp.股票买卖;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class 买卖股票的最佳时机含手续费 {


    public int maxProfit(int[] prices, int fee) {

        /**未持有的最大收益和持有的最大收益 */
        int notHold = 0;
        int hold = - prices[0];
        for(int i = 1; i < prices.length; i++){
            /**没有股票：之前就没有这次不买，之前有这次卖掉了,卖掉的时候收取手续费 */
            notHold = Math.max(notHold, hold + prices[i] - fee);
            /**持有股票：之前有这次不卖，之前没有这次买
             * 和单次买卖的区别在于，之前没有这次买的收益为 notHold - prices[i]，单次买卖的收益是 - prices[i]
             * */
            hold = Math.max(hold, notHold - prices[i]);
        }
        return notHold;
    }
}
