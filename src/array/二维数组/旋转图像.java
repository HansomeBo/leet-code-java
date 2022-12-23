package array.二维数组;

import util.PrintUtil;

/**
 * https://leetcode.cn/problems/rotate-image/
 * <p>
 * 先左右对称的交换，再沿着右上到左下的对接线交换
 * [1,2,3]
 * [4,5,6]
 * [7,8,9]
 * <p>
 * [3,2,1]
 * [6,5,4]
 * [9,8,7]
 * <p>
 * [7,4,1]
 * [8,5,2]
 * [9,6,3]
 */
public class 旋转图像 {

    public static void rotate(int[][] matrix) {
        int hight = matrix.length;
        int width = matrix[0].length;
        /*左右对称交换,hight不变，width对称*/
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < width / 2; j++) {
                swap(matrix, i, j, i, width - 1 - j);
            }
        }
        PrintUtil.printArray(matrix);
        /*右上到左下的对接线交换，higth和width互换*/
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < width - i; j++) {
                swap(matrix, i, j, hight - 1 - j, width - 1 - i);
            }
        }
        PrintUtil.printArray(matrix);
    }

    public static void swap(int[][] matrix, int l1, int r1, int l2, int r2) {
        int tmp = matrix[l1][r1];
        matrix[l1][r1] = matrix[l2][r2];
        matrix[l2][r2] = tmp;
    }

    public static void main(String[] args) {
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

}
