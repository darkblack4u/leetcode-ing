public class lc200 {
    /**
     * 200. 岛屿数量 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 
     * 此外，你可以假设该网格的四条边均被水包围。
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param grid
     * @return
     */
    boolean[][] hasProcess;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        hasProcess = new boolean[m][n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (hasProcess[i][j])
                    continue;
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ret++;
                }
                hasProcess[i][j] = true;
            }
        }
        return ret;
    }

    public void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i - 1 >= 0 && !hasProcess[i - 1][j]) {
            hasProcess[i - 1][j] = true;
            if (grid[i - 1][j] == '1') {
                bfs(grid, i - 1, j);
            }

        }
        if (i + 1 < m && !hasProcess[i + 1][j]) {
            hasProcess[i + 1][j] = true;
            if (grid[i + 1][j] == '1') {
                bfs(grid, i + 1, j);
            }

        }
        if (j - 1 >= 0 && !hasProcess[i][j - 1]) {
            hasProcess[i][j - 1] = true;
            if (grid[i][j - 1] == '1') {
                bfs(grid, i, j - 1);
            }
        }
        if (j + 1 < n && !hasProcess[i][j + 1]) {
            hasProcess[i][j + 1] = true;
            if (grid[i][j + 1] == '1') {
                bfs(grid, i, j + 1);
            }
        }
    }
}
