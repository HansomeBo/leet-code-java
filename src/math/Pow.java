package math;

/**
 * https://leetcode.cn/problems/powx-n/
 */
public class Pow {
    /**
     * 直接递归n次的操作会超出系统限制
     * 递归n/2次，每次对结果进行平方
     * 
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return n > 0 ? fastPow(x, n) : 1 / fastPow(x, -n);
    }

    /**
     * 因为n为负数时的计算方式不一样，拆分出一个递归的方法，只考虑n为正数的情况
     * @param x
     * @param n
     * @return
     */
    public double fastPow(double x, int n) {
        /** 边界条件 */
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;

        double y = fastPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().myPow(34.00515, -3));
    }
}
