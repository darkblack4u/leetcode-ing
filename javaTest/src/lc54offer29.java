import java.util.Scanner;

public class lc54offer29 {
    /**
     * 剑指 Offer 29. 顺时针打印矩阵
     * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
     * https://leetcode-cn.com/problems/spiral-matrix/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                matrix[i][j] = num;
            }
        }
        int[] ret = spiralOrder(matrix);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ret.length; i++) {
            sb.append(ret[i]).append(" ");
        }
        System.out.println(sb.toString());
        sc.close();
    }

    public static int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] ret = new int[n * m];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;
        int x = 0;
        while (true) {
            for (int i = left; i <= right; i++) {
                ret[x++] = matrix[up][i];
            }
            if (++up > down)
                break;
            for (int i = up; i <= down; i++) {
                ret[x++] = matrix[i][right];
            }
            if (--right < left)
                break;
            for (int i = right; i >= left; i--) {
                ret[x++] = matrix[down][i];
            }
            if (--down < up)
                break;
            for (int i = down; i >= up; i--) {
                ret[x++] = matrix[i][left];
            }
            if (++left > right)
                break;
        }
        return ret;
    }
}
