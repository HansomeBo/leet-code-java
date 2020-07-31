package easy;

import util.PrintUtil;

/**
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class 将每个元素替换为右侧最大元素 {

    public static void main(String[] args) {
        PrintUtil.printIntArray(replaceElements(new int[]{17,18,5,4,6,1}));
    }

    public static int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0){
            return null;
        }
        int maxNum = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = maxNum;
            if (tmp > maxNum){
                maxNum = tmp;
            }
        }
        return arr;
    }

}
