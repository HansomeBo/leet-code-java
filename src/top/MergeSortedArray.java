package top;


import util.PrintUtil;

public class MergeSortedArray {

    public static void main(String[] args) {
        merge2(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    /*进行遍历,但问题在于数组需要整体后移,这步操作比较麻烦 --> 使用m+n空间的数组进行存储*/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        for (int i = 0, j = 0; i + j < m + n; ) {
            if (i >= m) {
                res[i + j] = nums2[j++];
                continue;
            }
            if (j >= n) {
                res[i + j] = nums1[i++];
                continue;
            }
            if (i < m && nums1[i] < nums2[j]) {
                res[i + j] = nums1[i++];
            } else {
                res[i + j] = nums2[j++];
            }
        }
        nums1 = res;
        PrintUtil.printArray(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; ) {
            nums1[i + j] = nums1[i] < nums2[j] ? nums2[j --] : nums1[i --];
        }
        PrintUtil.printArray(nums1);
    }

}
