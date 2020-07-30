package top;

/**
 * https://leetcode-cn.com/problems/happy-number/
 *
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(5));
    }

    public static boolean isHappy(int n) {
        while (n != 1 ){
            n = calHappyNumber(n);
            System.out.println(n);
            if (n == 4){
                return false;
            }
        }
        return true;
    }

    public static int calHappyNumber(int n){
        int sum = 0;
        while (n > 0){
            int tmp = n % 10;
            sum += Math.pow(tmp,2);
            n = n / 10;
        }
        return sum;
    }


}
