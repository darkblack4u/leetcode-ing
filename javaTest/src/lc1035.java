import java.util.*;

public class lc1035 {
    /**
     * 1035. 不相交的线 https://leetcode-cn.com/problems/uncrossed-lines/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums1[i] = num;
        }
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            nums2[i] = num;
        }
        System.out.println(maxUncrossedLines(nums1, nums2));
        sc.close();
    }

    /**
     * 动态规划
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}