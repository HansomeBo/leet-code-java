package array.滑动窗口;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 难点在于处理是否滑动窗口的子串是否包含目标子串的判断 */
public class 最小覆盖子串 {

    private static int[] thash = new int[128];
    private static int[] shash = new int[128];

    public static String minWindow(String s, String t) {
        int left = 0;
        int right = 1;
        String res = "";
        for (char c : t.toCharArray()) thash[c]++;
        shash[s.charAt(left)]++;
        while (left <= right && left < s.length() && right <= s.length()) {
            String current= s.substring(left,right);
            if (contains()) {
                if ("".equals(res) || res.length() > current.length()) {
                    res = current;
                }

                shash[s.charAt(left)]--;
                left++;
            } else {
                right++;
                if(right <= s.length()) shash[s.charAt(right - 1)]++;
            }

        }
        return res;
    }

    public static boolean contains() {
        for (int i = 0; i < thash.length; i++) {
            if (thash[i] > shash[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC",
                "ABC"));
    }
}
