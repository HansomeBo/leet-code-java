package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 */
public class Permutations {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
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
        for (int i = 0; i < nums.length; i++) {
            // if(res.contains(nums[i])) continue;
            if (hash[i])
                continue;
            res.addLast(nums[i]);
            hash[i] = true;
            backTracking(nums, res, hash);
            res.pollLast();
            hash[i] = false;
        }
    }
}
