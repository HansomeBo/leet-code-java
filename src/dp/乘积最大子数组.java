package dp;

/**
 * https://leetcode.cn/problems/maximum-product-subarray
 */
public class 乘积最大子数组 {

    /**
     * [2,3,-2,4]
     * [2,3,-2,4,-1]
     * [2,3,-2,0,4,-1]
     * <p>
     * 分三种情况，正数，负数，0
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        /*记录截止每个索引的最大数和最小数*/
        int[][] dp = new int[nums.length][2];
        int preMax = nums[0];//上一个最大值
        int preMin = nums[0];//上一个最小值
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentMin, currentMax;
            if (nums[i] == 0) {
                currentMax = 0;
                currentMin = 0;
            } else if (nums[i] > 0) {//当前值 > 0
                currentMax = preMax > 0 ? preMax * nums[i] : nums[i];
                currentMin = preMin < 0 ? preMin * nums[i] : nums[i];
            } else {//当前值 < 0
                currentMax = preMin < 0 ? preMin * nums[i] : nums[i];
                currentMin = preMax > 0 ? preMax * nums[i] : nums[i];
            }
            max = Math.max(max, currentMax);
            System.out.println(preMax + "," + preMin + "," + max);
            preMax = currentMax;
            preMin = currentMin;
        }
        return max;
    }


    public static void main(String[] args) {
        int[] array = new int[]{-4, -3, -2};
        maxProduct(array);
    }
}
