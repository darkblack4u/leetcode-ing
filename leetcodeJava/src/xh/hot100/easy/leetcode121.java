package xh.hot100.easy;

public class leetcode121 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int[] dp = new int[prices.length - 1];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = prices[i + 1] - prices[i];
            if (i - 1 >= 0 && dp[i - 1] > 0) {
                dp[i] = dp[i] + dp[i - 1];
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min < 0) {
                min = prices[i];
            } else if (prices[i] - min > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }
}
