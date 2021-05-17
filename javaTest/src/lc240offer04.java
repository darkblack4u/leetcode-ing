import java.util.*;

public class lc240offer04 {
    /**
     * 剑指 Offer 04. 二维数组中的查找
     * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
     * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int target = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                matrix[i][j] = num;
            }
        }
        sc.close();
        System.out.println(findNumberIn2DArray(matrix, target));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            int a = matrix[i][j];
            if (a > target) {
                i--;
            } else if (a < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
