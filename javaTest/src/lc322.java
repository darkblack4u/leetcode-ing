import java.util.*;

public class lc322 {
    /**
     * 322. 零钱兑换 https://leetcode-cn.com/problems/coin-change/
     * 
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0)
                    continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}