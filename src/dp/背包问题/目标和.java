package dp.背包问题;

/**
 * https://leetcode-cn.com/problems/target-sum/
 */
public class 目标和 {

    /**
     * dp数组范围已经扩大到可以囊括每个数字选择和不选择的结果集了
     * 动态规划本身也是穷举，只是这个穷举的范围通过(sum - target)/2缩小了
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int length = nums.length;
        for(int i = 0; i < length; i++) sum += nums[i];
        /**添加-号的元素之和为neg,这句是精华 */
        if (sum - target < 0) return 0;
        if ((sum - target)%2 != 0) return 0;
        int neg = (sum - target)/2;
        /**dp[i][j]表示在数组nums的前i个数中选取元素，使得这些元素之和等于j的方案数 */
        int[][] dp = new int[length + 1][neg + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= length; i++){
            int num = nums[i - 1];
            for(int j = 0; j <= neg; j++){
                if(num > j){
                    /**不需要num凑出j */
                    dp[i][j] = dp[i - 1][j];
                }else{
                    /**需要num凑出j */
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }
        return dp[length][neg];
    }
}
