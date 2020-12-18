package easy;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class 最短无序连续子数组 {

    public static int findUnsortedSubarray(int[] nums) {
        int end = 0, start = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1] && i < start) {
                start = i;
            }
        }
        System.out.println(start);
        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 4, 3, 3, 7}));
    }

}
