package top;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class StrIndexOf {

    public static void main(String[] args) {
        System.out.println(strStr("aaa", "aaa"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int sourceCount = source.length;
        int targetCount = target.length;
        int max = sourceCount - targetCount ;
        for (int i = 0; i <= max; i++) {
            while (source[i] != target[0] && ++i <= max) ;
            int j = i + 1, k = 1;
            if(i <= max){
                while (k < targetCount && j < sourceCount && source[j] == target[k]) {
                    j++;
                    k++;
                }
                if (k == targetCount) {
                    return i;
                }
            }

        }
        return -1;
    }


}
