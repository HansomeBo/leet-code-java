package array;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        int head = 0;
        int end = nums.length - 1;
        while (head < end) {
            int headNum = nums[head];
            int endNum = nums[end];
            int currentSum = headNum + endNum;
            if (currentSum == target) {
                return new int[]{headNum, endNum};
            } else if (currentSum > target) {
                while (end > head && nums[end] == endNum) end--;
            } else if (currentSum < target) {
                while (head < end && nums[head] == headNum) head++;
            }
        }
        return null;
    }
}
