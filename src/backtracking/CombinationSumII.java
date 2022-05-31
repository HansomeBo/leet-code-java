package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum-ii/
 */
public class CombinationSumII {
    
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /**先将数组进行排序 */
        Arrays.sort(candidates);
        backTracking(candidates,target,new LinkedList<Integer>(),0);
        return list;
    }

    /**[1,1,2,5,6,7,10] */
    /**
     * 回溯+递归+剪枝
     * 剪枝：去掉重复的分支，横向遍历的分支不可重复，将上一次遍历弹出的最后一个数值记做pop，pop不能与下一次遍历的数值重复
     * @param candidates
     * @param target
     * @param res
     * @param startIndex
     */
    public void backTracking(int[] candidates, int target,LinkedList<Integer> res,int startIndex){
        if(target == 0){
            list.add(new ArrayList<Integer>(res));
        }
        if(target <= 0) return;
        int pop = -1;
        for(int i = startIndex; i < candidates.length; i++){
            if(pop == candidates[i]) continue;
            res.addLast(candidates[i]);
            backTracking(candidates,target - candidates[i],res,i + 1);
            pop = res.pollLast();
        }
    }

}
