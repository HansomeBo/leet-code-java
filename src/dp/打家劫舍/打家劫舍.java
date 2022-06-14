package dp.打家劫舍;

/**
 * https://leetcode.cn/problems/house-robber/
 */
public class 打家劫舍 {

    /**
     * 动态规划
     * 
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // **今天的最大金额 = max(今天打劫的金额 + 前天最大金额,昨天最大金额) */
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
