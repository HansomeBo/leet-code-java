package dp.背包问题;

/**
 * https://leetcode.cn/problems/last-stone-weight-ii/
 */
public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        /**选出一部分石头，使其重量尽可能趋近于总重量的一半 */
        int sum = 0;
        if (stones == null) return 0;
        if (stones.length == 1) return stones[0];
        for (int stone : stones) sum += stone;
        int target = sum / 2;
        boolean[][] dp = new boolean[stones.length + 1][target + 1];
        dp[0][0] = true;
        for(int i = 0; i < stones.length; i++){
            int stone = stones[i];
            for(int j = 0; j <= target; j++){
                if(stone > j){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = dp[i][j] || dp[i][j - stone];
                }
            }
        }
        for(int i = target; i > 0; i--){
            if(dp[stones.length][i]) return sum - 2*i;
        }
        return 0;
    }
}
