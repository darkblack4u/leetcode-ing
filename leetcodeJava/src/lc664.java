import java.util.*;

public class lc664 {
    /**
     * 664. 奇怪的打印机 https://leetcode-cn.com/problems/strange-printer/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(strangePrinter(s));
        sc.close();
    }

    /**
     * 动态规划
     * 
     * @param s
     * @return
     */
    public static int strangePrinter(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }
        return f[0][n - 1];
    }
}
