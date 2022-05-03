package tree;

import model.TreeNode;

/**
 * https://leetcode.cn/problems/sum-of-left-leaves/
 */
public class 左叶子之和 {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) sum = sum + root.left.val;
        sum = sum + sumOfLeftLeaves(root.left);
        sum = sum + sumOfLeftLeaves(root.right);
        return sum;
    }
}
