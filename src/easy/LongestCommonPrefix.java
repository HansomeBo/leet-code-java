package easy;

/*https://leetcode-cn.com/problems/longest-common-prefix/
  最长公共前缀
* */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /*时间复杂度 O(m*n)*/
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0){
            return "";
        }
        char[] first = strs[0].toCharArray();
        String result = "";
        for (int i = 0; i < first.length; i++) {
            for (int j = 1; j < strs.length; j++) {
                char[] compare = strs[j].toCharArray();
                if (i > compare.length - 1 || compare[i] != first[i]){
                    return result;
                }
            }
            result += first[i];
        }
        return result;
    }

}
