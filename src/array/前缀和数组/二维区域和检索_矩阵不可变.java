package array.前缀和数组;

/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * 方法类似区域检索_数组不变
 * 前缀和数组
 */
public class 二维区域和检索_矩阵不可变 {

    private static int[][] preSum;

    public static void NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i <= matrix.length; i++){
            for(int j = 1; j <= matrix[0].length; j++){
                preSum[i][j] = preSum[i][j - 1] + preSum[i - 1][j] + matrix[i -1][j - 1] - preSum[i - 1][j - 1];
            }
        }
    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
}
