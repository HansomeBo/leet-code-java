package tree;

import model.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class 从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        System.out.println("n:"+n);
        return buildTree(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[poEnd]);
        int inRoot = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == postorder[poEnd]){
                inRoot = i;
                break;
            }
        }
        int leftSize = inRoot - inStart;
        root.left = buildTree(inorder, inStart, inRoot - 1, postorder, poStart, poStart + leftSize - 1);
        root.right = buildTree(inorder, inRoot + 1, inEnd, postorder, poStart + leftSize, poEnd - 1);
        return root;
    }
}
