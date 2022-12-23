package array;

import util.PrintUtil;

import java.util.*;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class 前K个高频元素 {

    /**
     * 先遍历数组建立每个数字出现次数的映射map
     * 然后对map的value进行排序，排序后取map的前K个元素的key
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return map.entrySet().stream().sorted((v1, v2) -> v2.getValue() - v1.getValue()).mapToInt(Map.Entry::getKey).limit(k).toArray();
    }

    /**
     * 先遍历数组建立每个数字出现次数的映射map
     * 然后对map的value进行排序，排序后取map的前K个元素的key
     * 使用小根堆，比较原生实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequentII(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else if (queue.peek().getValue() < entry.getValue()) {
                queue.poll();
                queue.add(entry);
            }
        }
        int[] result = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : queue) {
            result[i++] = entry.getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new 前K个高频元素().topKFrequentII(new int[]{1, 1, 1, 1, 3, 3, 3, 4, 4}, 2);
        PrintUtil.printArray(result);
    }
}
