package top;

/**
 * https://leetcode-cn.com/problems/house-robber/
 *
 * 动态规划
 *
 */
public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{8,1,1,9}));
    }

    public static int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            System.out.println(prevMax + " , " + currMax );
            prevMax = temp;
        }
        return currMax;
    }

}
