package top;

/**
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class TrailingZeroes {

    public static void main(String[] args) {
//        452137076
        System.out.println(trailingZeroesPlus2(1808548329));
    }

    public static int trailingZeroes(int n) {
        int count2 = 0, count5 = 0;

        for (int i = 2; i <= n; i = i + 2) {
            count2 += logn(i, 2);
        }
        for (int i = 5; i <= n; i = i + 5) {
            count5 += logn(i, 5);
        }
        return Math.min(count2, count5) ;
    }
    /*
    * 5总是比2小
    * */
    public static int trailingZeroesPlus(int n) {
        int count = 0;

        for (int i = 5; i <= n; i = i + 5) {
            count += logn(i, 5);
        }
        return count;
    }
    /*
    * 5总是比2小
    * */
    public static int trailingZeroesPlus2(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    public static int logn(int tag, int logn) {
        int count = 0;
        while (tag % logn == 0 && tag > 0) {
            tag = tag / logn;
            count++;
        }
        return count;
    }

    public static int subStair(int n){
        int sum = 1;
        for (int i = 0; i <= n ; i++) {
            sum = sum * i;
        }
        return sum;
    }
}
