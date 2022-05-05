package array.滑动窗口;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 长度固定的滑动窗口
 */
public class 字符串排列 {

    public static boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for (char c : s1.toCharArray()) hash1[c - 'a'] ++;
        int start = 0;
        int end = s1.length() - 1;
        for (char c : s2.substring(start, end + 1).toCharArray()) hash2[c - 'a'] ++;
        while (end < s2.length()) {
            Boolean isEquals = true;
            for (int i = 0; i < hash1.length; i++) {
                if (hash1[i] != hash2[i]) {
                    isEquals = false;
                    break;
                }
            }
            if (isEquals) return true;
            hash2[s2.charAt(start) - 'a']--;
            start++;
            end++;
            if(end < s2.length()) hash2[s2.charAt(end) - 'a']++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("a",
                "ab"
        ));
    }
}
