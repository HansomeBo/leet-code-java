package array.滑动窗口;

import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class 无重复字符的最长子串 {

    private static int hash[] = new int[128];

    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)) return 0;
        int start = 0;
        int end = 0;
        int maxlength = 0;
        String window = s.substring(start, end + 1);
        for (char c : window.toCharArray()) hash[c]++;
        while (end < s.length()) {
            while (isUnique() && end < s.length()) {
                maxlength = Math.max(end - start + 1, maxlength);
                end++;
                if (end < s.length()) hash[s.charAt(end)]++;
            }
            hash[s.charAt(start)]--;
            start++;
        }
        return maxlength;
    }

    public static boolean isUnique() {
        for (int i : hash) {
            if (i > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
