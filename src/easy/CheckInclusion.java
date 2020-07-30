package easy;

/**
 * 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 目前此解超时
 */
public class CheckInclusion {

    public static void main(String[] args) {
//        System.out.println(checkEqual("1a2c3","321ca"));
        System.out.println(checkInclusion("ab", "eidoooba"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        for (int i = 0; i + length <= s2.length(); i++) {
            String tmp = s2.substring(i, i + length);
            if (checkEqual(tmp, s1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkEqual(String s1, String s2) {
        String[] array = s1.split("");
        for (int i = 0; i < array.length; i++) {
            s2 = s2.replaceFirst(array[i], "");
        }
        if ("".equals(s2)) {
            return true;
        }
        return false;
    }

}
