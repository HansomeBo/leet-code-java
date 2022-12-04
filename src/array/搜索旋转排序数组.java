package array;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */
public class 搜索旋转排序数组 {

    /**
     * 二分法
     * 解题关键点：将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
     * 无序区间无法判断，需要通过排除法，可以明确判断是否在有序区间，如果不在，那就在另一个区间，继续在下一个区间二分
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int left, int right) {
        if (left <= right - 1) {
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            return -1;
        }
        int mid = (right - left) / 2 + left;
        if (nums[mid] == target) return mid;
        if (nums[left] < nums[mid]) {/*左区间有序*/
            if (nums[left] <= target && target < nums[mid]) {/*目标在左区间*/
                return search(nums, target, left, mid - 1);
            } else {
                return search(nums, target, mid + 1, right);
            }
        } else {/*右区间有序*/
            if (nums[mid] < target && target <= nums[right]) {/*目标值在右区间*/
                return search(nums, target, mid + 1, right);
            } else {
                return search(nums, target, left, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1}, 1));
    }
}
