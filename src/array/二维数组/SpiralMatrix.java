package array.二维数组;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/submissions/
 */
public class SpiralMatrix {
    
    /**
     * 一道烂题，不做也罢
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int lengthx = matrix.length;
        int lengthy = matrix[0].length;
        boolean[][] mem = new boolean[lengthx][lengthy];
        int[][] directionMap = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        List<Integer> res = new ArrayList<Integer>();
        int nextx = 0;
        int nexty = 0;
        /**
        [1,2,3,4]
        [5,6,7,8]
        [9,10,11,12]
        [13,14,15,16]
         */
        int direct = 0;
        int allEleNums = lengthx * lengthy;
        while(res.size() < allEleNums){
            res.add(matrix[nextx][nexty]);
            mem[nextx][nexty] = true;
            int preNextx = nextx + directionMap[direct][0];
            int preNexty = nexty + directionMap[direct][1];
            if(preNextx >= 0 && preNextx < lengthx && preNexty >= 0 && preNexty < lengthy && !mem[preNextx][preNexty]){
                /**不需要转向 */
                nextx = preNextx;
                nexty = preNexty;
            }else{
                /**需要转向 */
                direct = (direct + 1) % 4;
                nextx = nextx + directionMap[direct][0];
                nexty = nexty + directionMap[direct][1];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
