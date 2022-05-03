package linkedlist;

import model.TreeNode;

public class 平衡二叉树 {

    /**
     * 双层递归
     * 第一层递归：遍历所有节点
     * 第二层递归：计算每个节点的左右自己点的深度
     */
    class Solution1 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            if(Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
            if(!isBalanced(root.left)) return false;
            if(!isBalanced(root.right)) return false;
            return true;
        }

        public int depth(TreeNode node){
            if(node == null) return 0;
            return Math.max(depth(node.left),depth(node.right)) + 1;
        }
    }

    /**
     * 单层递归
     * 将计算深度时会遍历所有节点，将两个递归合并
     */
    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            if (depth(root) < 0) return false;
            return true;
        }

        public int depth(TreeNode node){
            if(node == null) return 0;
            int leftLength = depth(node.left);
            int rightLength = depth(node.right);
            if (leftLength == -1 || rightLength == -1 || Math.abs(leftLength - rightLength) > 1) return -1;
            return Math.max(leftLength,rightLength) + 1;
        }
    }
}
