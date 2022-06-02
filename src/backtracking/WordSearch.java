package backtracking;

/**
 * https://leetcode.cn/problems/word-search/
 */
public class WordSearch {

    private boolean[][] visited;

    private String word;

    private char[][] board;

    private int lengthx;

    private int lengthy;

    private int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        lengthx = board.length;
        lengthy = board[0].length;
        visited = new boolean[lengthx][lengthy];
        /**尝试所有节点作为起始节点 */
        for (int i = 0; i < lengthx; i++) {
            for (int j = 0; j < lengthy; j++) {
                boolean res = backTracking(i, j, 0);
                if (res)
                    return true;
            }
        }
        return false;
    }

    public boolean backTracking(int x, int y, int wordIndex) {
        /** 越界或者已经访问过，返回false */
        if (x >= lengthx || y >= lengthy || x < 0 || y < 0 || visited[x][y])
            return false;
        if (board[x][y] != word.charAt(wordIndex))
            return false;
        /** 终止条件，已经找到合适的路径 */
        if (wordIndex == word.length() - 1)
            return true;
        /** 入栈 */
        visited[x][y] = true;
        /**四个方向，分别尝试 */
        for (int i = 0; i < direction.length; i++) {
            int nextx = x + direction[i][0];
            int nexty = y + direction[i][1];
            boolean res = backTracking(nextx, nexty, wordIndex + 1);
            if (res)
                return true;
        }
        /** 出栈 */
        visited[x][y] = false;
        return false;
    }
}
