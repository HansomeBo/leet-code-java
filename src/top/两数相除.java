package top;

/**
 * https://leetcode.cn/problems/divide-two-integers/
 */
public class 两数相除 {

    public int divide(int dividend, int divisor) {
        int sum = 0;
        int result = 0;
        while (sum < dividend){
            sum += divisor;
            result++;
        }
        return result;
    }
}
