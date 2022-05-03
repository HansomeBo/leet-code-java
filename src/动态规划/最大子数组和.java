package 动态规划;

/**
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class 最大子数组和 {

    /**
     * dp备忘录，dp[i]表示以nums[i]为结尾的数组最大和
     * 状态转移方程：dp[i = max(dp[i + nums[i], nums[i])
     * 因为子数组必须连续，当前数值选择要么与前面的数组的最大值合并，要么不合并
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        //以i结尾的备忘录
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        for(int i = 1; i < dp.length; i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
