package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/word-break/
 */
public class 单词拆分 {

    /**
     * 动态规划
     * 
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);
        /** 当字符串长度为0时为true */
        dp[0] = true;
        /** i -> j (i < j) 的状态转移 
         * dp[j] = dp[i] && wordDict.contains(s.substring(i, j)
         * */
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (dp[i] && set.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
