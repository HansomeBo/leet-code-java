package easy;

/*https://leetcode-cn.com/problems/two-sum/*/
public class FindSum {

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

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = twoSum(nums,7);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
