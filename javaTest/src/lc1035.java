import java.util.*;

public class lc1035 {
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
     * 1035. 不相交的线 https://leetcode-cn.com/problems/uncrossed-lines/
     * 
     * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
     * 
     * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
     * 
     *  nums1[i] == nums2[j] 且绘制的直线不与任何其他连线（非水平线）相交。 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
     * 
     * 以这种方法绘制线条，并返回可以绘制的最大连线数。
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/uncrossed-lines
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
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