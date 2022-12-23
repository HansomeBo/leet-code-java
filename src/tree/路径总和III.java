package tree;

import model.TreeNode;

/**
 * https://leetcode.cn/problems/path-sum-iii/
 *
 * 双重递归
 */
public class 路径总和III {

    int originalTargetSum;

    public int pathSum(TreeNode root, int targetSum) {
        return dfsNew(root,Long.valueOf(targetSum));
    }

    public int dfsNext(TreeNode root, Long targetSum){
        if (root == null) return 0;
        int count = 0;
        if(targetSum - root.val == 0){
            count++;
        }
        count += dfsNext(root.left, targetSum - root.val);
        count += dfsNext(root.right, targetSum - root.val);
        return count;
    }


    public int dfsNew(TreeNode root, Long targetSum){
        if (root == null) return 0;
        int count = 0;
        count += dfsNext(root, targetSum);

        count += dfsNew(root.left, targetSum);
        count += dfsNew(root.right, targetSum);
        return count;
    }

    /**
     * 这个方法总是会算重复
     * 如果树的高度只有两层的话，不会计算重复
     * 当到树的第三层，开始计算重复
     * @param root
     * @param targetSum
     * @return
     */
    public int dfs(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int count = 0;
        if(targetSum - root.val == 0){
            count++;
            targetSum = originalTargetSum;
        }
        count += dfs(root.left, targetSum - root.val);
        count += dfs(root.right, targetSum - root.val);
        count += dfs(root.left, originalTargetSum);
        count += dfs(root.right, originalTargetSum);
        return count;
    }

}
