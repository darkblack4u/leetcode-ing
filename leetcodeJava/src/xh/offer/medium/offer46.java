package xh.offer.medium;

public class offer46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        char[] ss = s.toCharArray();
        int[] dp = new int[ss.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (ss[i - 2] == '1' || (ss[i - 2] == '2') && ss[i - 1] < '6') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
