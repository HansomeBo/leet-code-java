package top;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 二叉树的最大深度
 * 递归遍历　Ｏ(n)
 */
public class MaxDepth {

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            int left = maxDepth(root.left) + 1;
            int right = maxDepth(root.right) + 1;
            return Math.max(left,right);
        }
    }

    public class TreeNode{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
