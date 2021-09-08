import java.util.*;

public class lc1738 {
    /**
     * 1738. 找出第 K 大的异或坐标值
     * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                matrix[i][j] = num;
            }
        }
        sc.close();
        System.out.println(kthLargestValue(matrix, k));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                ret.add(dp[i][j]);
            }
        }
        Collections.sort(ret, (Integer a, Integer b) -> {
            return b - a;
        });
        return (int) ret.get(k - 1);
    }
}
