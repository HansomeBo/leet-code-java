package dp;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class 最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        /**
         迭代分别找出1……nums.length的子序列
         */
        /**dp备份表记录长度为n的子序列的最大长度以及索引位置，初始化为最大长度为1 */
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            int maxLength = 0;
            /*去找当前这个节点前最长的且小于当前节点的那个节点位置*/
            for (int j = 0; j < i; j++){
                if(nums[j] < nums[i]) maxLength = Math.max(maxLength, dp[j]);
            }
            dp[i] = maxLength + 1;
        }
        /*最后，取dp表中的最大值*/
        int max = 0;
        for(int i = 0; i < dp.length; i++) max = Math.max(max,dp[i]);
        return max;
    }
}
