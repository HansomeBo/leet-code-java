package order;

import util.PrintUtil;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                        array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        PrintUtil.printIntArray(bubbleSort(new int[]{3,4,5,1,2}));
    }
}
