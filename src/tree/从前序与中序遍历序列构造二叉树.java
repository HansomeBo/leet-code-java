package tree;

import model.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 从preorder中确定根节点
 * 从inorder中找到根节点，并确定左树的长度
 * 左树 preStart + 1，preStart + leftSize
 *      inStart, inRoot - 1
 * 右树 preStart + leftSize + 1, preEnd
 *      inRoot + 1, inEnd
 */
public class 从前序与中序遍历序列构造二叉树 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preStart]) {
                inRoot = i;
                break;
            }
        }
        int leftSize = inRoot - inStart;
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftSize, inStart, inRoot - 1);
        root.right = buildTree(preorder, inorder, preStart + leftSize + 1, preEnd, inRoot + 1, inEnd);
        return root;
    }
}
