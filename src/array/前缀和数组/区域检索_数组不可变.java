package array.前缀和数组;

import util.PrintUtil;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
public class 区域检索_数组不可变 {

    private static int[] preSum;

    public static void NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public static int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
        NumArray(new int[]{-2,0,3,-5,2,-1});
        PrintUtil.printArray(preSum);
        System.out.println(sumRange(0,2));
    }
}
