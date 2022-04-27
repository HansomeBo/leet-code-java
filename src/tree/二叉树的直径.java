package tree;

import model.TreeNode;

/**
 * 正常思路，左节点深度+右节点深度为当前节点为根节点的直径，遍历所有节点，比较出最大直径
 *  所以是两个回调循环，深度计算+每个节点的直径计算
 * 技巧：树的深度遍历时就将左右深度加在一起和最长直径做比较，免得两次回调循环
 */
public class 二叉树的直径 {

    private static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public static int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        int diameter = left + right;
        if (diameter > maxDiameter) maxDiameter = diameter;
        return Math.max(left, right) + 1;
    }

}
