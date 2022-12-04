package order;

import util.PrintUtil;

/**
 * 核心方法partition，将数组[left - right]的区间分成两部分，中轴左边部分小于中轴，中轴右边部分大于中轴，并返回中轴的索引
 * 优化点在于中轴的选择上：总是选第一个元素，随机选择，从三个数中选择一个随机数
 * 无论那种中轴选择都要将中轴放到left位置上，这样partition才好分区
 */
public class 快速排序 {

    public void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序的递归函数
     *
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;/*左右区间边界重合已经不需要再递归排序*/
        int mid = partition(nums, left, right);/*分区*/
        quickSort(nums, left, mid - 1);/*中轴左边继续排序*/
        quickSort(nums, mid + 1, right);/*中轴右边继续排序*/
    }

    /**
     * 最简单的中轴选择，将left作为中轴的数值
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        int mid = left;/*中轴最终的索引位置*/
        for (int i = mid + 1; i <= right; i++) {/*从中轴的后一个位置开始遍历*/
            if (nums[i] < nums[left]) {/*当前节点小于中轴*/
                mid++;/*把当前节点往中轴后面排*/
                swap(nums, i, mid);
            }
        }
        /*left - mid 都是中轴的左区间，left是中轴的值，mid是最后一个小于mid的值*/
        swap(nums, left, mid);/*中轴归位*/
        return mid;/*返回中轴坐标*/
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 8, 9, 1, 3, 6, 7, 4};
        new 快速排序().quickSort(nums);
        PrintUtil.printIntArray(nums);
    }

}
