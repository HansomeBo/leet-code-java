package util;

public class PrintUtil {

    public static void printIntArray(int[] array) {
        System.out.print("array:");
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void printIntArray(int[][][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                for (int i2 = 0; i2 < array[i][i1].length; i2++) {
                    System.out.println("[" + i + " ," + i1 + " ," + i2 + " ] : " + array[i][i1][i2]);
                }
            }
        }
    }

    public static void printObjectArray(Object[] array) {
        System.out.print("array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + ":" + array[i] + ",");
        }
        System.out.println();
    }
}
