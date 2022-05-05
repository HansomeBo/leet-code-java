package array.滑动窗口;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 难点在于处理是否滑动窗口的子串是否包含目标子串的判断
 */
public class 最小覆盖子串 {

    static class Solution {
        private int[] thash = new int[128];
        private int[] shash = new int[128];

        public String minWindow(String s, String t) {
            int left = 0;
            int right = 0;
            String res = "";
            /*初始化targer字符串、窗口内的字符串*/
            for (char c : t.toCharArray()) thash[c]++;
            for (char c : s.substring(left, right + 1).toCharArray()) shash[c]++;
            /*右指针最多移动到最右边*/
            while (right < s.length()) {
                /*当包含时，左指针移动，直到不再包含，右指针再移动*/
                while (isContains() && left <= right) {
                    if ("".equals(res) || res.length() > right + 1 - left) {
                        res = s.substring(left, right + 1);
                    }
                    shash[s.charAt(left)]--;
                    left++;
                }
                right++;
                if (right < s.length()) shash[s.charAt(right)]++;

            }
            return res;
        }

        public Boolean isContains() {
            for (int i = 0; i < thash.length; i++) {
                if (thash[i] > shash[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC",
                "ABC"));
    }
}
