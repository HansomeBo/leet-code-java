package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/
 */
public class CombinationSum {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, new LinkedList<>(), 0);
        return list;
    }

    /**
     * 回溯的函数，因为结果集不能重复，所以记录遍历到的索引位置，从索引位置向后遍历
     * 
     * @param candidates
     * @param target
     * @param res
     */
    public void backtracking(int[] candidates, int target, LinkedList<Integer> res, int startIndex) {
        if (target == 0)
            list.add(new ArrayList<>(res));
        if (target < 0)
            return;

        for (int i = startIndex; i < candidates.length; i++) {
            res.addLast(candidates[i]);
            backtracking(candidates, target - candidates[i], res, i);
            res.pollLast();
        }
    }

}
