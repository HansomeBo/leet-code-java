package palindrome;

/**
 * https://leetcode.cn/problems/palindromic-substrings/
 */
public class 回文子串 {

    /**
     * 动态规划
     * dp[i][j]表示从i到j是不是回文字符串
     * dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
     * 从动态转移的方向逆向遍历
     * i从length到0遍历
     * j从0到length遍历
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int length = s.length();
        int count = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        count++;
                    } else if (i + 1 < length && j - 1 >= 0 && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 从中心点向两头扩展统计
     *
     * @param s
     * @return
     */
    public static int countSubstringsII(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            /*以i为中心点*/
            count += countByCenterChar(array, i, i);
            /*以i和i+1为中心点*/
            if (i + 1 < array.length) count += countByCenterChar(array, i, i + 1);
        }
        return count;
    }

    /**
     * 注意传过来的参数要重新赋值，不然会修改到外层的变量
     *
     * @param array
     * @param leftIndex
     * @param rigthIndex
     * @return
     */
    public static int countByCenterChar(char[] array, int leftIndex, int rigthIndex) {
        int count = 0;
        for (int left = leftIndex, right = rigthIndex; left >= 0 && right < array.length; left--, right++) {
            if (array[left] == array[right]) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
