package easy;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class 反转字符串中的单词III {

    public static String reverseWords(String s) {
        String result = "";
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                result = result + " " + tmp;
                tmp = "";
            } else {
                tmp = s.charAt(i) + tmp;
            }
        }
        return (result + " " + tmp).trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
