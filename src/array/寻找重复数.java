package array;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/
 */
public class 寻找重复数 {


    /**
     * 快慢指针
     * 如果没有重复数字的情况下，则nums[n] -> nums[nums[n]] -> ……这样会形成一个单向连续的链表
     * 有重复数字的情况下，这样会在链表上面形成一个环，双指针找出环
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        fast = nums[fast];
        fast = nums[fast];
        slow = nums[slow];
        while (fast != slow){
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];
        }
        slow = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    /*1234566
    * 0123456
    *
    * [1,3,4,2]
    * [0,1,2,3]
    * 1,3,2,4,2
    * */

    /**
     * 自己写的，修改了原数组，不符合题意
     * @param nums
     * @return
     */
    public int findDuplicateII(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int num = nums[i];
            if (num == i) {
                i++;
            } else {
                if (nums[num] == num) return num;
                swap(nums, i, num);
            }
        }
        return 0;
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}
