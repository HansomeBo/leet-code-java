package array.二维数组;

/**
 * https://leetcode.cn/problems/number-of-islands/
 * <p>
 * 这题首先很难读懂
 * 每个由1连在一起的区块看作是一个岛屿，数处有多少区块
 * 遍历整个数组，当遍历到1时，递归的去找和当前1相连的1，把这些1全部改成2，这样1不会重复遍历
 * 每次遍历到1，岛屿数量加1
 *
 * 1，1，1
 * 0，1，0
 * 1，1，1
 */
public class 岛屿数量 {


    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void infect(char[][] grid, int i, int j) {
        /*数组越界判断*/
        if (i < 0 | i >= grid.length | j < 0 | j >= grid[0].length) return;
        /*递归截止的判断*/
        if (grid[i][j] == '0' || grid[i][j] == '2') return;
        /*变更当前的陆地*/
        grid[i][j] = '2';
        /*四个方向都要递归一下*/
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j + 1);
        infect(grid, i, j - 1);
    }
}
