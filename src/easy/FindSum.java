package easy;

import java.util.HashMap;
import java.util.Map;

/*https://leetcode-cn.com/problems/two-sum/*/
public class FindSum {

    /**
     * 返回两个数
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i ++){
            for(int j = i + 1 ; j < nums.length ; j ++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    /**
     * 一边处理数据一边生成Map，不要所有数据转化成map处理
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) return new int[]{index,i};
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = twoSum(nums,7);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
