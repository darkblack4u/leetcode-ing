package xh.hot100;

public class leetcode85 {
    public static void main(String[] args) {

    }

    public int maximalRectangle(char[][] matrix) {
        int h = matrix.length;
        if (h == 0)
            return 0;
        int w = matrix[0].length;
        if (w == 0)
            return 0;
        int[][] dp = new int[h][w];

    }
}
