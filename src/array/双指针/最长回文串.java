package array.双指针;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class 最长回文串 {

    public static String longestPalindrome(String s) {
        String maxString = "";
        if(s == null) return "";
        if(s.length() == 1) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            String curString = longestPalindrome(s, i, i);
            if (curString.length() > maxString.length()) maxString = curString;
            if (s.charAt(i) == s.charAt(i + 1)) curString = longestPalindrome(s, i, i + 1);
            if (curString.length() > maxString.length()) maxString = curString;
        }
        return maxString;
    }

    public static String longestPalindrome(String s, int start, int end) {
        while (start - 1 >= 0 && end + 1 < s.length() && s.charAt(start - 1) == s.charAt(end + 1)) {
            start--;
            end++;
        }
        return s.substring(start, end + 1);
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("1bab"));
    }
}
