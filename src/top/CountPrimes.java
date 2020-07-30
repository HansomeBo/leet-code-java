package top;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/count-primes/
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimesSieve(499979));
    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (jugePrimes(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean jugePrimes(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * Sieve of Eratosthenes
     * 埃拉托色尼筛选法
     * 互斥遍历
     * */
    public static int countPrimesSieve(int n) {
        Boolean[] nums = new Boolean[n];
        int count = 0;
        /*初始化为true*/
        Arrays.fill(nums, true);
        for (int i = 2; i * i < n ; i++) {
            if (nums[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    nums[j] = false;
                }
            }
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i]){
                count ++;
            }
        }
        return count;
    }

}
