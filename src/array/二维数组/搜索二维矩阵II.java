package array.二维数组;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 *
 * 二分查找每次搜索可以排除半行或半列的元素，Z字形查找每次搜索可以排除一行或一列的元素。
 */
public class 搜索二维矩阵II {

    /**
     * Z字形查找
     * 一行一行排除
     * 以左上角或者右下角为比较点
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0){
            int leftTop = matrix[x][y];
            if (leftTop == target) return true;
            if (leftTop > target){
                y = y - 1;
            }else {
                x = x + 1;
            }
        }
        return false;
    }

}
