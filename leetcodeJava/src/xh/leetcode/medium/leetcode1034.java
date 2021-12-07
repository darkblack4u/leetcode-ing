package xh.leetcode.medium;

import java.util.*;

public class leetcode1034 {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] hasProcess = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int[][] newGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < newGrid.length; i++) {
            for (int j = 0; j < newGrid[0].length; j++) {
                newGrid[i][j] = grid[i][j];
            }
        }
        int currentColor = grid[row][col];
        queue.offer(new int[] { row, col });
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];
                if (r + 1 < grid.length && grid[r + 1][c] == currentColor) {
                    if (!hasProcess[r + 1][c]) {
                        queue.offer(new int[] { r + 1, c });
                    }
                } else {
                    newGrid[r][c] = color;
                }
                if (r - 1 >= 0 && grid[r - 1][c] == currentColor) {
                    if (!hasProcess[r - 1][c]) {
                        queue.offer(new int[] { r - 1, c });
                    }
                } else {
                    newGrid[r][c] = color;
                }
                if (c + 1 < grid[0].length && grid[r][c + 1] == currentColor) {
                    if (!hasProcess[r][c + 1]) {
                        queue.offer(new int[] { r, c + 1 });
                    }
                } else {
                    newGrid[r][c] = color;
                }
                if (c - 1 >= 0 && grid[r][c - 1] == currentColor) {
                    if (!hasProcess[r][c - 1]) {
                        queue.offer(new int[] { r, c - 1 });
                    }
                } else {
                    newGrid[r][c] = color;
                }
                hasProcess[r][c] = true;
            }
        }
        return newGrid;
    }
}
