package tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class 二叉搜索树中的众数 {


    private List<Integer> res = new ArrayList<Integer>();

    private int base,count,maxCount;

    public int[] findMode(TreeNode root) {
        forEach(root);
        int[] array = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            array[i] = res.get(i);
        }
        return array;
    }

    public void forEach(TreeNode root){
        if(root == null) return;
        forEach(root.left);
        if(root.val == base){
            count++;
        }else{
            base = root.val;
            count = 1;
        }
        if(count == maxCount){
            res.add(base);
        }else if(count > maxCount){
            res.clear();
            res.add(base);
            maxCount = count;
        }
        forEach(root.right);
    }
}
