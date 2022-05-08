package array.滑动窗口;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class 无重复字符的最长子串 {

    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)) return 0;
        int start = 0;
        int end = 0;
        int maxlength = 1;
        int hash[] = new int[128];
        String window = s.substring(start, end + 1);
        for (char c : window.toCharArray()) hash[c]++;
        while (end + 1 < s.length()) {
            while (end + 1 < s.length() && hash[s.charAt(end + 1)] == 0) {
                end++;
                maxlength = Math.max(end - start + 1, maxlength);
                hash[s.charAt(end)]++;
            }
            hash[s.charAt(start)]--;
            start++;
        }
        return maxlength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
