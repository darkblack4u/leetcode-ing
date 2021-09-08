import java.util.*;

public class offer54 {
    /**
     * 54. 螺旋矩阵 https://leetcode-cn.com/problems/spiral-matrix/
     * 
     * @param strings
     */
    public static void main(String[] strings) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        // if (n == 0) {
        // return new ArrayList<Integer>();
        // }
        int m = matrix[0].length;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int left = 0;
        int right = m - 1;
        int up = 0;
        int down = n - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                ret.add(matrix[up][i]);
            }
            if (++up > down)
                break;
            for (int i = up; i <= down; i++) {
                ret.add(matrix[i][right]);
            }
            if (--right < left)
                break;
            for (int i = right; i >= left; i--) {
                ret.add(matrix[down][i]);
            }
            if (--down < up)
                break;
            for (int i = down; i >= up; i--) {
                ret.add(matrix[i][left]);
            }
            if (++left > right)
                break;
        }
        return ret;
    }
}
