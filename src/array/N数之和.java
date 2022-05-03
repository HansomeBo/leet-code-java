package array;

import util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2、3、4之和的通用方法
 * 使用前先对nums数组进行排序
 */
public class N数之和 {

    public static List<List<Integer>> nsum(int[] nums, int start, int n, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 2) {
            int head = start;
            int end = nums.length - 1;
            while (head < end) {
                int headNum = nums[head];
                int endNum = nums[end];
                int currentSum = headNum + endNum;
                if (currentSum == target) {
                    res.add(Arrays.asList(nums[head], nums[end]));
                    while (end > head && nums[end] == endNum) end--;
                    while (head < end && nums[head] == headNum) head++;
                } else if (currentSum > target) {
                    while (end > head && nums[end] == endNum) end--;
                } else if (currentSum < target) {
                    while (head < end && nums[head] == headNum) head++;
                }
            }
        } else {
            while (start <= nums.length - n) {
                int currentNum = nums[start];
                List<List<Integer>> tmp = nsum(nums, start + 1, n - 1, target - currentNum);
                for (List<Integer> integers : tmp) {
                    List<Integer> resnums = new ArrayList<>();
                    resnums.add(currentNum);
                    resnums.addAll(integers);
                    res.add(resnums);
                }
                while (start <= nums.length - n && currentNum == nums[start]) start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(nsum(new int[]{1, 2, 3, 3, 4, 4, 5, 6, 6, 7}, 0, 3, 8));
    }
}
