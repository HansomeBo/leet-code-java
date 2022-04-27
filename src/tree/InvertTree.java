package tree;

import model.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转树
 */
public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    
}
