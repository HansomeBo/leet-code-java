package dp;

/**
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 */
public class 下降路径最小和 {

    public int minFallingPathSum(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[width][height];
        for(int i = 0; i < width; i++) dp[0][i] = matrix[0][i];

        for(int i = 1; i < height; i++){
            for(int j = 0; j < width; j++){
                int beforeMin = dp[i - 1][j];
                if(j > 0) beforeMin = Math.min(dp[i - 1][j - 1], beforeMin);
                if(j < width - 1) beforeMin = Math.min(dp[i - 1][j + 1], beforeMin);
                dp[i][j] = beforeMin + matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int way : dp[height - 1]) min = Math.min(min,way);
        return min;
    }

}
