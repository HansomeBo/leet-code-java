package top;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
// TODO
public class BestTimeToBuy {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfitPlus(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            for (int j = i + 1; j < prices.length; j++) {
                int tmp = prices[j] - prices[i];
                if (tmp > max){
                    max = tmp;
                }
            }

        }
        return max;
    }

    public static int maxProfitPlus(int[] prices) {
        if (prices == null){
            return 0;
        }
        int min = prices[0];
        int fall = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }
            int tmp = prices[i] - min;
            if (tmp > fall){
                fall = tmp;
            }
        }
        return fall;
    }

}
