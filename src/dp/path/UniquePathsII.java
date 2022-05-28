package dp.path;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1) return 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                     /**当前节点有石头，到达当前节点的路径可能性为0 */
                    dp[i][j] = 0;
                }else if( i == 0 && j == 0){
                    dp[i][j] = 1;
                }else if(i == 0){
                    /**边界值 */
                    dp[i][j] = dp[i][j - 1];
                }else if(j == 0 ){
                    /**边界值 */
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 将dp表压缩成一维数组
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesII(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        if(obstacleGrid[0][0] == 1) return 0;
        dp[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                     /**当前节点有石头，到达当前节点的路径可能性为0 */
                    dp[j] = 0;
                }else if (j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
