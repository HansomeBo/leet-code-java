package dp.背包问题;

/**
 * https://leetcode.cn/problems/ones-and-zeroes/
 */
public class OnesandZeroes {
    
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for(int i = 1; i <= strs.length; i++){
            int[] countArray = count(strs[i - 1]);
            int zeros = countArray[0];
            int ones = countArray[1];
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    if(j - zeros >= 0 && k - ones >= 0){
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],dp[i - 1][j - zeros][k - ones] + 1);
                    }else{
                        dp[i][j][k] = dp[i-1][j][k]; 
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int[] count(String str){
        int[] countArray = new int[2];
        for(char c : str.toCharArray()) countArray[c - '0']++;
        return countArray;
    }

    public static void main(String[] args) {
        new OnesandZeroes().findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3);
    }
}
