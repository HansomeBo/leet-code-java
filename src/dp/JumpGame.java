package dp;

/**
 * https://leetcode.cn/problems/jump-game/
 */
public class JumpGame {
    
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int maxDistance = 0;
        for(int i = 0; i < length; i++){
            if(maxDistance < i) return false;
            maxDistance = Math.max((i + nums[i]),maxDistance);
        }
        return maxDistance >= length - 1;
    }


}
