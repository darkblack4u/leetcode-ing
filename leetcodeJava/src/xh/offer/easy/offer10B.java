package xh.offer.easy;

public class offer10B {
    public int numWays(int n) {
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
