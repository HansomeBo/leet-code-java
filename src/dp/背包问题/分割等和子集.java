package dp.背包问题;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class 分割等和子集 {

    public boolean canPartition(int[] nums) {
        if (nums == null) return false;
        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum,num);
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        if (maxNum > target) return false;
        /**dp[i][j]表示在数组nums的第i个数中选取元素，是否能组成可以分割的结果 */
        boolean[][] dp = new boolean[nums.length][target + 1];
        /*
         * 在定义状态之后，需要考虑边界情况。以下两种情况都属于边界情况。
         * 如果不选取任何正整数，则被选取的正整数等于 0。dp[i][0] = true;
         * 当 i==0 时，只有一个正整数 nums[0] 可以被选取，因此 dp[0][nums[0]] = true。
         * */
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                }
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - num] | dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

}
