package array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray
 * 技巧性很强
 * 最简单思路，将数组拷贝一份，对拷贝出来的数据进行排序
 * 然后比较两个数组，两端重合的部分不需要排序
 */
public class 最短无序连续子数组 {

    /**
     * 从左到右循环，记录最大值为 max，若 nums[i] < max, 则表明位置 i 需要调整, 循环到数组结束，记录需要调整的最大位置 i 为 high;
     * 同理，从右到左循环，记录最小值为 min, 若 nums[i] > min, 则表明位置 i 需要调整，循环到数组结束，记录需要调整的最小位置 i 为 low.
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int max = nums[0];
        int min = nums[nums.length - 1];
        int high = 0;/*右侧需要调整的索引*/
        int low = 0;/*左侧需要调整的索引*/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                high = i;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min){
                min = nums[i];
            }else {
                low = i;
            }
        }
        if(high == low) return 0;
        return high - low + 1;
    }
}
