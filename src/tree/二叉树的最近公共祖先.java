package tree;

import model.TreeNode;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class 二叉树的最近公共祖先 {

    /**
     * 自底向上的遍历
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /*left和right都不为空的情况下才算找到了共同祖先*/
        if (left != null && right != null) return root;

        /*这种判断条件下并不是说left或者rigth就是公共祖先，在遍历到实际的公共祖先节点前不是，在遍历到实际的公共祖先节点后是*/
        if (left == null && right != null) return right;
        if (left != null && right == null) return left;
        return null;
    }

}
