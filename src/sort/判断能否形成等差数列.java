package sort;

import util.PrintUtil;

import java.util.Arrays;

public class 判断能否形成等差数列 {

    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[]{13, 12, -12, 9, 9, 16, 7, -10, -20, 0, 18, -1, -20, -10, -8, 15, 15, 16, 2, 15}));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if (arr == null || arr.length < 3) return true;
        int balance = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (balance != arr[i+1] - arr[i]) return false;
        }
        return true;
    }

}
