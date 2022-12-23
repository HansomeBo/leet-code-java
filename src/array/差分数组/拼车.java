package array.差分数组;

import util.PrintUtil;

/**
 * https://leetcode-cn.com/problems/car-pooling/submissions/
 * 边界值都给我搞蒙了
 *
 */
public class 拼车 {

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[20];
        for (int i = 0; i < trips.length; i++) {
            diff[trips[i][1]] += trips[i][0];
            diff[trips[i][2]] -= trips[i][0];
        }
        PrintUtil.printArray(diff);
        int[] nums = new int[20];
        nums[0] = diff[0];
        if (nums[0] > capacity) return false;
        for (int i = 1; i < 20; i++) {
            nums[i] = nums[i - 1] + diff[i];
            if(nums[i] > capacity) return false;
        }
        PrintUtil.printArray(nums);
        return true;
    }

    public static void main(String[] args) {
        carPooling(new int[][]{{9,0,1},{3,3,7}},4);
    }
}
