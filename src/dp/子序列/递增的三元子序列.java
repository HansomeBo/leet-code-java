package dp.子序列;

/**
 * https://leetcode.cn/problems/increasing-triplet-subsequence/
 * 贪心
 */
public class 递增的三元子序列 {
    
    /**
     * 
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        /**[1,2,3,4,5]
         * 动态规划的思路会超时
         * 因为题目限定了序列长度为三，所以将结果集压缩为三位数字
         * 结果集有可能是多个，贪心思路只保留最小的那个数值，最小的第一位，最小的第二位
         * 找到第三位就返回成功
         */
        int minFirst = nums[0];
        int minSecond = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > minSecond) return true;
            if(nums[i] < minSecond && nums[i] > minFirst) minSecond = nums[i];
            if(nums[i] < minFirst) minFirst = nums[i];
        }
        return false;
    }
}
