package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组相对排序 {

    public static void main(String[] args) {
        Integer[] s = relativeSortArrayII(new Integer[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    /**
     * 通过自定义排序
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> sortMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) sortMap.put(arr2[i], i);
        customizeSort(arr1, sortMap);
        return arr1;
    }

    public static int[] customizeSort(int[] arr1, Map<Integer, Integer> sortMap) {
        boolean isFinish = true;
        for (int i = 0; i < arr1.length - 1; i++) {
            if (sortMap.getOrDefault(arr1[i], 1000 + arr1[i]) > sortMap.getOrDefault(arr1[i + 1], 1000 + arr1[i + 1])) {
                int tmp = arr1[i];
                arr1[i] = arr1[i + 1];
                arr1[i + 1] = tmp;
                isFinish = false;
            }
        }
        if (!isFinish) return customizeSort(arr1, sortMap);
        return arr1;
    }

    public static Integer[] relativeSortArrayII(Integer[] arr1, int[] arr2) {
        Map<Integer, Integer> sortMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) sortMap.put(arr2[i], i);
        Arrays.sort(arr1,
                (x, y) -> {
                    return sortMap.getOrDefault(x, 1000 + x) - sortMap.getOrDefault(y, 1000 + y);
                });
        return arr1;
    }
}
