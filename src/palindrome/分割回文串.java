package palindrome;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/
 * abbbsss
 */
public class 分割回文串 {

    private List<List<String>> result = new ArrayList<>();
    private LinkedList<String> palindromeList = new LinkedList<>();

    public List<List<String>> partition(String s) {
        partition(s,0);
        return result;
    }

    public void partition(String s, int startIndex) {
        /**遍历到最后面了，终止纵向遍历 */
        if (startIndex >= s.length()) {
            result.add(new LinkedList<>(palindromeList));
            return;
        }
        /**横向遍历 */
        for (int i = startIndex + 1; i <= s.length(); i++) {
            /**截取从startIndex到i的字符串，判断是不是回文串，是的话就放到当前的堆栈中 */
            String currentString = s.substring(startIndex, i);
            if (isPalindrome(currentString)) {
                palindromeList.offer(currentString);
                /**纵向遍历 */
                partition(s, i);
                /**纵向遍历完，将堆栈中的尾部元素弹出并删除，重新进行横向遍历 */
                palindromeList.pollLast();
            }
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s))
            return true;
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 分割回文串().partition("abb"));
    }
}
