package top;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 思路:dp[i] = dp[i-1] + dp[i-2]
 * 即,爬到第i阶可以从i-1阶爬一层,或i-2阶爬两层
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairsRecursive(44));
        System.out.println(climbStairsRecursivePlus(44, new int[44 + 1]));
        System.out.println(climbStairsDynamic(44));
    }

    /*简单递归*/
    public static int climbStairsRecursive(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    /*记忆递归*/
    public static int climbStairsRecursivePlus(int n, int[] array) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        if (array[n] > 0) {
            return array[n];
        }
        array[n] = climbStairsRecursivePlus(n - 1, array) + climbStairsRecursivePlus(n - 2, array);
        return array[n];
    }

    /*动态规划*/
    public static int climbStairsDynamic(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

}
