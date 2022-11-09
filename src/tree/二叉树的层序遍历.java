package tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/?favorite=2cktkvj
 */
public class 二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        while (currentLevel != null && currentLevel.size() > 0) {
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> currentNum = new ArrayList<>();
            for (TreeNode treeNode : currentLevel) {
                currentNum.add(treeNode.val);
                if (treeNode.left != null) nextLevel.add(treeNode.left);
                if (treeNode.right != null) nextLevel.add(treeNode.right);
            }
            currentLevel = nextLevel;
            res.add(currentNum);
        }
        return res;
    }

    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (nodeQueue != null && nodeQueue.size() > 0) {
            List<Integer> currentNum = new ArrayList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = nodeQueue.poll();
                currentNum.add(treeNode.val);
                if (treeNode.left != null) nodeQueue.offer(treeNode.left);
                if (treeNode.right != null) nodeQueue.offer(treeNode.right);
            }
            res.add(currentNum);
        }
        return res;
    }
}
