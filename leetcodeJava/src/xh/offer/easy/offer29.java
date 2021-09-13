package xh.offer.easy;

public class offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int count = 0;
        int left = 0, right = col - 1, up = 0, down = row - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[count] = matrix[up][i];
                count++;
            }
            if (++up > down)
                break;
            for (int i = up; i <= down; i++) {
                res[count] = matrix[i][right];
                count++;
            }
            if (left > --right)
                break;
            for (int i = right; i >= left; i--) {
                res[count] = matrix[down][i];
                count++;
            }
            if (up > --down)
                break;
            for (int i = down; i >= up; i--) {
                res[count] = matrix[i][left];
                count++;
            }
            if (++left > right)
                break;
        }
        return res;
    }
}
