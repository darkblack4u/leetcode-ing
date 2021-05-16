import java.util.Scanner;

public class offer42 {
    /**
     * 剑指 Offer 42. 连续子数组的最大和
     * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(maxSubArray(nums));
    }

    /**
     * 动态规划
     * 
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int ret = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }
            ret = Math.max(dp[i], ret);
        }
        return ret;
    }
}
