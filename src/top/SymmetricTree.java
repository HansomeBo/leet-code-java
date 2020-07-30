package top;


import model.TreeNode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(treeNode);
        System.out.println(isSymmetric(treeNode));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        /*结束条件*/
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        /*镜面的判断逻辑*/
        if (left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)) {
            return true;
        }
        return false;
    }
}
