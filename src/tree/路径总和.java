package tree;

import model.TreeNode;

public class 路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        targetSum = targetSum - root.val;
        if(root.left == null && root.right == null && targetSum == 0) return true;
        if(root.left != null && hasPathSum(root.left,targetSum)) return true;
        if(root.right != null && hasPathSum(root.right,targetSum)) return true;
        return false;
    }
}
