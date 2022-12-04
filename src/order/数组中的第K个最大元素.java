package order;

import javax.xml.bind.annotation.XmlInlineBinaryData;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * 快速排序变形
 * 中轴索引的位置代表了第K个最大元素的位置
 */
public class 数组中的第K个最大元素 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,5,6,3,8,2,3,7};
        System.out.println(new 数组中的第K个最大元素().findKthLargest(nums,6));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    /**
     * 快速排序的递归函数
     *
     * @param nums
     * @param left
     * @param right
     */
    public int quickSort(int[] nums, int left, int right, int target) {
        int mid = partition(nums, left, right);/*分区*/
        if (target - 1 == mid) return nums[mid];
        if (target - 1 < mid) {/*只排一边就好了*/
            return quickSort(nums, left, mid, target);
        }else {
            return quickSort(nums, mid + 1, right, target);
        }
    }

    /**
     * 最简单的中轴选择，将left作为中轴的数值
     * 因为是找最大的某个数，所以左边放成大于中轴的数值，右边放成小于中轴的数值，方便外面索引的比较
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        int mid = left;/*中轴最终的索引位置*/
        for (int i = mid + 1; i <= right; i++) {/*从中轴的后一个位置开始遍历*/
            if (nums[i] > nums[left]) {/*当前节点大于中轴*/
                mid++;/*把当前节点往中轴后面排*/
                swap(nums, i, mid);
            }
        }
        /*left - mid 都是中轴的左区间，left是中轴的值，mid是最后一个大于mid的值*/
        swap(nums, left, mid);/*中轴归位*/
        return mid;/*返回中轴坐标*/
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

}
