package top;


import util.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        PrintUtil.printIntArray(intersect(new int[]{4, 5, 8}, new int[]{4, 6, 8, 10}));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = transArrayToMap(nums1);
        HashMap<Integer, Integer> map2 = transArrayToMap(nums2);
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = map1.keySet();
        for (int index : set) {
            int count = min(map1.get(index), map2.get(index));
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    list.add(index);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static HashMap<Integer, Integer> transArrayToMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return map;
    }

    public static int min(Integer a, Integer b) {
        if (a == null || b == null) {
            return 0;
        }
        return Math.min(a, b);
    }
}
