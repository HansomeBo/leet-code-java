package tree;

import model.TreeNode;

/**
 * https://leetcode.cn/problems/convert-bst-to-greater-tree
 */
public class 把二叉搜索树转换为累加树 {


    int sum = 0;

    /*中序遍历即可，把遍历的值做累加*/
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

}
