package top;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqCharII("ssllkookkd"));
    }

    public static int firstUniqCharI(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return 0;
    }

    public static int firstUniqCharII(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i],map.getOrDefault(array[i],0) + 1);
        }
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

}
