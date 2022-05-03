package tree;

import model.TreeNode;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class 二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p.val <= root.val && q.val >= root.val) return root;
        if(p.val >= root.val && q.val <= root.val) return root;
        TreeNode res = lowestCommonAncestor(root.left,p,q);
        if(res != null) return res;
        return lowestCommonAncestor(root.right,p,q);
    }
}
