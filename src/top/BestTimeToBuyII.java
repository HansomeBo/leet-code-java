package top;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
//
public class BestTimeToBuyII {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{5, 5, 4, 9, 3, 8, 5, 5, 1, 6, 8, 3, 4}));
        System.out.println(maxProfitPlus(new int[]{5, 5, 4, 9, 3, 8, 5, 5, 1, 6, 8, 3, 4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int buy = 0, sell = 0, profit = 0;
        boolean buyFlag = false;
        if (prices[0] <= prices[1]) {
            buy = prices[0];
            buyFlag = true;
            System.out.println("buy:" + buy);
        }
        for (int i = 1; i < prices.length - 1; i++) {
            if (!buyFlag && prices[i - 1] >= prices[i] && prices[i] < prices[i + 1]) {
                /*低拐点买入*/
                buy = prices[i];
                buyFlag = true;
                System.out.println("buy:" + buy);
            } else if (buyFlag && prices[i - 1] <= prices[i] && prices[i] > prices[i + 1]) {
                /*高拐点卖出*/
                sell = prices[i];
                buyFlag = false;
                System.out.println("sell:" + sell);
                /*卖出后增加收益*/
                profit = profit + (sell - buy);
            }
        }
        if (buyFlag && prices[prices.length - 1] >= prices[prices.length - 2]) {
            /*高拐点卖出*/
            sell = prices[prices.length - 1];
            /*卖出后增加收益*/
            buyFlag = false;
            System.out.println("sell:" + sell);
            profit = profit + (sell - buy);
        }
        return profit;
    }

    public static int maxProfitPlus(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

}
