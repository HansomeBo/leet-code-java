package sort;

import java.util.Arrays;

public class 三角形的最大周长 {

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3, 6, 2, 3}));
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int max = nums[i];
            int mid = nums[i - 1];
            int min = nums[i - 2];
            if (min + mid > max) return max + min + mid;
        }
        return 0;
    }
}
