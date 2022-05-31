package array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            int headIndex = i + 1;
            int endIndex = nums.length - 1;
            while(headIndex < endIndex){
                int sum = nums[headIndex] + nums[endIndex] + nums[i];
                int balance = Math.abs(target - closest) - Math.abs(target - sum);
                if(balance > 0){
                    closest = sum;
                }
                if(target - sum > 0){
                    headIndex++;
                }else{
                    endIndex--;
                }
            }
        }
        return closest;
    }
}
