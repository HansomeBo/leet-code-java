package top;


import model.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] n = new int[]{-10, -3, -2, 0,3, 5, 9};
        TreeNode tree = sortedArrayToBST(n);
        System.out.println(tree);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTReCall(nums, 0, nums.length);
    }

    private static TreeNode sortedArrayToBSTReCall(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTReCall(nums, start, mid);
        root.right = sortedArrayToBSTReCall(nums, mid + 1, end);

        return root;
    }

}
