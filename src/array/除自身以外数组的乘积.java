package array;

import util.PrintUtil;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/
 */
public class 除自身以外数组的乘积 {

    /**
     * left和right记录左边的乘积和右边的乘积
     * res就是left 和 right的乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        left[0] = 1;
        int[] right = new int[length];
        right[length - 1] = 1;
        int[] res = new int[length];
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            int j = length - 1 - i;
            right[j] = right[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    /**
     * 左右的乘积都可以压缩成用一个数来存储
     * @param nums
     * @return
     */
    public int[] productExceptSelfII(int[] nums) {
        int left = 1;
        int rigth = 1;
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int j = length - 1 - i;/*右索引*/
            /*如果左右索引还没相交，只用单独记左边，如果已经相交，那么res[i]已经包含右边的乘积，所以左右相乘即为 res[i] * left*/
            res[i] = i <= j ? left : res[i] * left;
            res[j] = j > i ? rigth : res[j] * rigth;
            left = left * nums[i];/*截止到i左边数的乘积*/
            rigth = rigth * nums[j];/*截止到j右边数的乘积*/
        }
        return res;
    }

    public static void main(String[] args) {
        PrintUtil.printIntArray(new 除自身以外数组的乘积().productExceptSelfII(new int[]{3,2,3,0,4}));
    }


}
