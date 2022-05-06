package tree;

import model.TreeNode;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class 二叉树展开为链表 {


    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);

        /**左右子树已经展开成单链表 */
        TreeNode left = root.left;
        TreeNode right = root.right;
        /**将左子树挂在右边，将左子树位置置空,左子树是空的话直接返回就好了 */
        if(left == null) return;
        root.right = left;
        root.left = null;
        /**将右子树挂在左子树的最后一个节点上 */
        while(left.right != null){
            left = left.right;
        }
        left.right = right;
    }
}
