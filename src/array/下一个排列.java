package array;

import util.PrintUtil;


/**
 * https://leetcode.cn/problems/next-permutation/
 * 例如 2, 6, 3, 5, 4, 1 这个排列， 我们想要找到下一个刚好比他大的排列，于是可以从后往前看
 * 我们先看后两位 4, 1 能否组成更大的排列，答案是不可以，同理 5, 4, 1也不可以
 * 直到3, 5, 4, 1这个排列，因为 3 < 5， 我们可以通过重新排列这一段数字，来得到下一个排列
 * 因为我们需要使得新的排列尽量小，所以我们从后往前找第一个比3更大的数字，发现是4
 * 然后，我们调换3和4的位置，得到4, 5, 3, 1这个数列
 * 因为我们需要使得新生成的数列尽量小，于是我们可以对5, 3, 1进行排序
 * 可以发现在这个算法中，我们得到的末尾数字一定是倒序排列的，于是我们只需要把它反转即可 最终，我们得到了4, 1, 3, 5这个数列
 * 完整的数列则是2, 6, 4, 1, 3, 5
 */
public class 下一个排列 {

    /**
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int index = -1;
        /*从右向左找到第一个左边比右边小的相邻的两个数*/
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
                break;
            }
        }
        /*从右向左找到第一个比index大的数，交换两个数值，如果没找到index就不用翻转*/
        if (index != -1) {
            for (int j = nums.length - 1; j > index; j--) {
                if (nums[j] > nums[index]) {
                    swap(nums, index, j);
                    break;
                }
            }
        }
        /*翻转index右侧的整个数组*/
        int left = index + 1;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        if (left == right) return;
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        PrintUtil.printArray(nums);
    }

}
