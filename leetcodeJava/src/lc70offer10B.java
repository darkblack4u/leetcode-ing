import java.util.Scanner;

public class lc70offer10B {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numWays(n));
        sc.close();
    }

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * 
     * 
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 
     * 
     * 
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if (n == 0)
            return 1;
        if (n < 3)
            return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if (dp[i] >= 1000000007) {
                dp[i] -= 1000000007;
            }
        }
        return dp[n - 1];
    }
}
