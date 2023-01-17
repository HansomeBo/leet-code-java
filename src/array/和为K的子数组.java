package array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 */
public class 和为K的子数组 {

    /**
     * 暴力循环
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int rightIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum == k) {count++;}
            }
        }
        return count;
    }

}
