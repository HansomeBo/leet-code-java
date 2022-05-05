package array.滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class 找到字符串中所有字母异位词 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int start = 0;
        int end = p.length() - 1;

        int[] shash = new int[26];
        int[] phash = new int[26];
        for (char c : s.substring(start, end + 1).toCharArray()) shash[c - 'a']++;
        for (char c : p.toCharArray()) phash[c - 'a']++;
        while (end < s.length()) {
            boolean equals = true;
            for (int i = 0; i < shash.length; i++) {
                if (shash[i] != phash[i]) equals = false;
            }
            if (equals) res.add(start);
            shash[s.charAt(start) - 'a']--;
            start++;
            end++;
            if (end < s.length()) shash[s.charAt(end) - 'a']++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd",
                "abc"
        ));
    }
}
