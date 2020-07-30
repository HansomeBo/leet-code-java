package easy;

import java.util.HashSet;
import java.util.Set;

/*https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 无重复字符的最长子串
*/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("12322"));
    }

    /*双指针,滑动窗口*/
    public static int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int ans = 0, i = 0, j = 0;
        String result = "";
        Set<Character> set = new HashSet<>();
        /*判断右指针位置,将右指针向右滑动,左指针不动
        * 当条件不满足时将左指针向右滑动,右指针不动
        * */
        while (i < array.length && j < array.length) {
            if (!set.contains(array[j])) {
                set.add(array[j++]);
                if (j - i > ans){
                    result = s.substring(i,j);
                }
                ans = Math.max(ans, j - i);
            } else {
                set.remove(array[i++]);
            }
        }
        System.out.println(result);
        return ans;
    }

    /*int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
        // try to extend the range [i, j]
        if (!set.contains(s.charAt(j))){
            set.add(s.charAt(j++));
            ans = Math.max(ans, j - i);
        }
        else {
            set.remove(s.charAt(i++));
        }
    }
    return ans;*/
}
