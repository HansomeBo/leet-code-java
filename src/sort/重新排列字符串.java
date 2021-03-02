package sort;

import java.util.HashMap;
import java.util.Map;

public class 重新排列字符串 {

    public static void main(String[] args) {
        System.out.println(restoreStringII("codeleet",new int[]{4,5,6,7,0,2,1,3}));
    }

    public static String restoreString(String s, int[] indices) {
        Map<Integer, Character> map = new HashMap<>();
        StringBuffer result = new StringBuffer("");
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i],s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            result.append(map.get(i));
        }
        return result.toString();
    }

    public static String restoreStringII(String s, int[] indices) {
        char[] result = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            result[indices[i]]= s.charAt(i);
        }
        return new String(result);
    }


}
