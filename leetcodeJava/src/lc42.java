import java.util.Scanner;

public class lc42 {
    /**
     * 42. 接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            height[i] = h;
        }
        System.out.println(trap(height));
        sc.close();
    }

    /**
     * 动态规划
     * 
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int ret = 0;
        int[] left = new int[height.length];
        left[0] = 0;
        int[] right = new int[height.length];
        right[height.length - 1] = 0;
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i - 1], left[i - 1]);
            right[height.length - 1 - i] = Math.max(height[height.length - i], right[height.length - i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            ret += Math.min(left[i], right[i]) > height[i] ? Math.min(left[i], right[i]) - height[i] : 0;
        }
        return ret;
    }
}
