package array;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 双指针
 */
public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while(start < end){
            max = Math.max(Math.min(height[start],height[end]) * (end - start),max);
            if(height[start] < height[end]) {
                start++;
            }else{
                end--;
            }
        }
        return max;
    }
}
