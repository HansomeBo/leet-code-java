package dp;

/**
 * https://leetcode.cn/problems/jump-game-ii/
 */
public class JumpGameII {

    public static void main(String[] args) {
        jump(new int[] { 2, 3, 1, 1, 4 });
    }

    public static int jump(int[] nums) {
        int preMaxIndex = 0;
        int curMaxIndex = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curMaxIndex = Math.max(curMaxIndex, nums[i] + i);
            /** 当前值是上次跳的最远距离,更新最远跳的距离，更新步数，但是当前节点不一定是下一个起跳点 */
            if (i == preMaxIndex) {
                step++;
                preMaxIndex = curMaxIndex;
            }
        }
        return step;
    }

}
