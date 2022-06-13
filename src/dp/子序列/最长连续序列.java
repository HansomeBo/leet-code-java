package dp.子序列;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        /** dp,key - nums中元素，value - 包含这个key的最长序列长度 */
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLength = 0;
        for (int num : nums) {
            /** 元素有可能会重复，重复的数据跳过，不重复计算 */
            if (dp.get(num) != null)
                continue;
            int left = dp.getOrDefault(num - 1, 0);
            int right = dp.getOrDefault(num + 1, 0);
            int curLength = left + right + 1;
            dp.put(num, curLength);
            /**只更新边界值，除了当前值和边界值之间的这部分数，用不到，所以就不浪费资源更新了。
             * 动态规划也只从边界值往外迭代
             */
            dp.put(num - left, curLength);
            dp.put(num + right, curLength);
            maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }
}
