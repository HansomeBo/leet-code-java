package tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 经典 递归
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        inorder(root,res);
        return res;
    }
    public static void inorder(TreeNode node,List<Integer> res){
        if (node == null) return;
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }


}
