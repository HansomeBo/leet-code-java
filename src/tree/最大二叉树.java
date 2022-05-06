package tree;

import model.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class 最大二叉树 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeII(nums,0,nums.length);
    }

    public TreeNode constructMaximumBinaryTreeII(int[] nums,int start,int end) {
        if(start >= end) return null;
        int max = 0;
        int maxIndex = start;
        /*找出最大的那个数值*/
        for(int i = start; i < end; i++){
            if(nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        /*构造左右的子树*/
        root.left = constructMaximumBinaryTreeII(nums,start,maxIndex);
        root.right = constructMaximumBinaryTreeII(nums,maxIndex + 1,end);
        return root;
    }
}
