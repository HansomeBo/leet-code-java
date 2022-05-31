package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations-ii/
 */
public class PermutationsII {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums, new LinkedList<Integer>(), new boolean[nums.length]);
        return list;
    }

    /**
     * 
     * @param nums
     * @param res
     * @param hash 用来记录已经有那些数值排列过了，相当于一个映射表，每次出栈入栈后修改hash
     */
    public void backTracking(int[] nums, LinkedList<Integer> res, boolean[] hash) {
        /** 终止条件：所有数值都已经排列 */
        if (res.size() == nums.length) {
            list.add(new ArrayList<Integer>(res));
            return;
        }
        /**题目限制了nums[i] <= 10 */
        int poll = 11;
        for (int i = 0; i < nums.length; i++) {
            /**重复的根节点不进行递归，跳到下一个根节点递归 */
            if (nums[i] == poll)
                continue;
            /**如果当前节点已经遍历，跳到下一个节点遍历 */
            if (hash[i])
                continue;
            res.addLast(nums[i]);
            hash[i] = true;
            backTracking(nums, res, hash);
            poll = res.pollLast();
            hash[i] = false;
        }
    }
}
