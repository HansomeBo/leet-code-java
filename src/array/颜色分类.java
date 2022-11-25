package array;

import util.PrintUtil;

/**
 * https://leetcode.cn/problems/sort-colors
 */
public class 颜色分类 {

    /**
     * 双指针
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int left = 0;
        for (int i = 0; i < 2; i++) {
            int right = left + 1;
            while (right < nums.length) {
                if (nums[left] == i) {
                    left++;
                    if (right <= left) right++;
                } else if (nums[left] != i && nums[right] == i) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                    right++;
                } else if (nums[left] != i && nums[right] != i) {
                    right++;
                }
            }
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
