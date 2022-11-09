package dp;

/**
 * https://leetcode.cn/problems/unique-binary-search-trees/
 */
public class 不同的二叉搜索树 {

    static int allnum = 0;

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            /*当树节点长度为i时，计算总的树结果*/
            for (int j = 1; j <= i; ++j) {
                /**
                 * 当以j为根节点的结果，1……j……i
                 */
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static int numTreesCount(int n) {
        if (n == 1 || n == 0) return n;
        for (int i = 1; i <= n; i++) {
            int num = numTrees(n - 1) + numTrees(n + 1);
            allnum += num;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
