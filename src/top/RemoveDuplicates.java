package top;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * <p>
 * 删除排序数组中的重复项
 * 双指针遍历
 *
 * 按照数组的移动操作好傻
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 2, 2, 3, 4, 4, 4, 6, 6, 6, 6}));
        System.out.println(removeDuplicatesPlus(new int[]{1, 2, 2, 3, 4, 4, 4, 6, 6, 6, 6}));
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{1, 1}));
        System.out.println(removeDuplicates(new int[]{1, 2}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            if (nums[0] == nums[1]) return 1;
            return 2;
        }
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] == nums[i - 2]) {
                for (int j = i; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[nums.length - 1]) {
                count++;
            } else {
                return ++count;
            }
        }
        return 0;
    }

    public static int removeDuplicatesPlus(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println("");
    }
}
