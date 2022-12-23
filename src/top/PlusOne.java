package top;


import util.PrintUtil;

public class PlusOne {

    public static void main(String[] args) {
        PrintUtil.printArray(plusOne(new int[]{8,9,9}));
    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        int pop = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + pop;
            pop = tmp / 10;
            digits[i] = tmp % 10;
        }
        if (digits[0] == 0){
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
