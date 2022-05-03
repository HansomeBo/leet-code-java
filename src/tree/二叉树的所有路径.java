package tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-paths/
 */
public class 二叉树的所有路径 {
    List<String> res = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePathsString(root,null);
        return res;
    }


    public void binaryTreePathsString(TreeNode root, String s) {
        if (root == null) return;
        if(s == null){
            s = root.val + "";
        } else{
            s = s+ "->" + root.val;
        }
        if(root.right == null && root.left == null) {
            res.add(s);
        }else{
            binaryTreePathsString(root.left,s);
            binaryTreePathsString(root.right,s);
        }
    }
}
