package util;

public class PrintUtil {

    public static void printIntArray(int[] array) {
        System.out.print("array:");
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void printObjectArray(Object[] array) {
        System.out.print("array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + ":" + array[i] + ",");
        }
        System.out.println();
    }
}
