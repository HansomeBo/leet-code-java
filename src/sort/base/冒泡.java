package sort.base;

import util.PrintUtil;

public class 冒泡 {
    public static void main(String[] args) {
        PrintUtil.printIntArray(bubble(new int[]{3,5,7,1,2,9,3,6,7}));
    }

    public static int[] bubble(int[] arr) {
        boolean isFinish = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isFinish = false;
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
        if (!isFinish) bubble(arr);
        return arr;
    }
}
