package array.差分数组;

/**
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 */
public class 航班预订统计 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];
        int[] nums = new int[n];
        for(int i = 0; i <  bookings.length; i++){
            diff[bookings[i][0] - 1] += bookings[i][2];
            diff[bookings[i][1]] -= bookings[i][2];
        }
        nums[0] = diff[0];
        for(int i = 1; i < nums.length; i++){
            nums[i] = diff[i] + nums[i - 1];
        }
        return nums;
    }
}
