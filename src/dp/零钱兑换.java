package dp;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class 零钱兑换 {

    class 带备忘录的递归 {

        public int coinChange(int[] coins, int amount) {
            int[] dpTable = new int[amount + 1];
            return coinChangeII(coins, amount, dpTable);
        }

        public int coinChangeII(int[] coins, int amount, int[] dpTable) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            if (dpTable[amount] > 0) return dpTable[amount];
            int minCount = -1;
            for (int coin : coins) {
                int count = coinChangeII(coins, amount - coin, dpTable);
                if (count == -1) continue;
                if (minCount == -1) {
                    minCount = count + 1;
                } else {
                    minCount = Math.min(count + 1, minCount);
                }
            }
            /*将计算结果记到dp表中*/
            dpTable[amount] = minCount;
            return minCount;
        }
    }

    class 带备忘录的迭代 {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            int[] dpTable = new int[amount + 1];
            /*将一个硬币能拼凑成的金额初始化出来*/
            for (int coin : coins) {
                if (coin <= amount) dpTable[coin] = 1;
            }
            /*迭代计算出这些硬币能组成的所有金额，并将最小的组成个数记录下来*/
            for (int i = 0; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0 && dpTable[i - coin] > 0) {
                        if (dpTable[i] == 0) {
                            dpTable[i] = dpTable[i - coin] + 1;
                        } else {
                            dpTable[i] = Math.min(dpTable[i], dpTable[i - coin] + 1);
                        }
                    }
                }
            }
            if (dpTable[amount] == 0) return -1;
            return dpTable[amount];
        }
    }
}
