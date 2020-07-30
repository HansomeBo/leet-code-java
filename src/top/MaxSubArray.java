package top;

/**
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 最大子序和
 * 正数增益
 * 负数减益
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,-5,-3,-1}));
    }

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
