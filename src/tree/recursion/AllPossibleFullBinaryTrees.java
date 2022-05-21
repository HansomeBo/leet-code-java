package tree.recursion;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**
 * https://leetcode.cn/problems/all-possible-full-binary-trees/submissions/
 */
public class AllPossibleFullBinaryTrees {
    
    /**
     * 最基本的递归
     * 构造左子树和右子树，左子树和右子树的情况有多种
     * @param n
     * @return
     */
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n == 1){
            list.add(new TreeNode(0));
            return list;
        }
        int leftAndRight = n - 1;
        for (int i = 1; i < leftAndRight; i++) {
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(leftAndRight - i);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }

}
