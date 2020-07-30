package model;


import util.PrintUtil;
import util.StringUtil;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


    /* 方案1 ： 字符串跨行拼接 + 递归
     * 方案2 ： 数组 + 计算间隔拼接
     * */
    @Override
    public String toString() {
        int depth = maxDepth(this);
        Integer[] array = this.getArray();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            /*拿到每个字符之间的间隔*/
            String interval = StringUtil.getNumbersSameString(" ", (int) Math.pow(2, depth - i - 1) - 1);
            /*进行字符拼接*/
            for (int j = 0; j < Math.pow(2, i); j++) {
                str.append(interval + array[(int) Math.pow(2, i) + j - 1] + interval + " ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public TreeNode(int x) {
        val = x;
    }


    /*获取树的最大深度*/
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left) + 1;
            int right = maxDepth(root.right) + 1;
            return Math.max(left, right);
        }
    }

    /*由数组生成树的方法*/
    public static TreeNode getTreeNode(Integer array[]) {
        if (array == null) {
            return null;
        }
        return getNextTreeNode(array, 1);
    }


    static TreeNode getNextTreeNode(Integer array[], int index) {
        if (index - 1 >= array.length || array[index - 1] == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(array[index - 1]);
        treeNode.left = getNextTreeNode(array, 2 * index);
        treeNode.right = getNextTreeNode(array, 2 * index + 1);
        return treeNode;
    }

    /*由树生成数组的方法*/
    public Integer[] getArray() {
        int depth = maxDepth(this);
        Integer[] array = new Integer[(int) Math.pow(2, depth) - 1];
        getNextArray(array, this, 1);
        return array;
    }

    static void getNextArray(Integer[] array, TreeNode treeNode, int index) {
        if (treeNode == null){
            return;
        }
        array[index - 1] = treeNode.val;
        if (treeNode.left == null && treeNode.right == null) {
            return;
        }
        getNextArray(array, treeNode.left, 2 * index);
        getNextArray(array, treeNode.right, 2 * index + 1);
        return;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        Integer[] array = treeNode.getArray();
        PrintUtil.printObjectArray(array);
        System.out.println(treeNode);
    }

}
