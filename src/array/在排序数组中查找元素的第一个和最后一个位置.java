package array;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (res[0] == -1) {
                    res[0] = i;
                    res[1] = i;
                } else {
                    res[1] = i;
                }
            }
        }
        return res;
    }

    /**
     * 二分查找法，注意二分查找的循环，避免陷入死循环
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRangeII(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0;
        int index = 0;
        int right = nums.length - 1;
        while (left <= right) {
            index = left + (right - left) / 2;
            if (nums[index] == target) {
                break;
            } else if (nums[index] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        if (nums[index] != target) return new int[]{-1, -1};
        left = index;
        right = index ;
        while (left >= 0 && nums[left] == target) left --;
        while (right < nums.length && nums[right] == target) right ++;
        return new int[]{left + 1,right - 1};
    }

}
