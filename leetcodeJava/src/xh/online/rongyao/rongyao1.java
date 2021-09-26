package xh.online.rongyao;

import java.util.Scanner;

public class rongyao1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < scores.length; i++) {
            int score = sc.nextInt();
            scores[i] = score;
        }
        System.out.println(maxScore(scores));
        sc.close();
    }

    public static int maxScore(int[] scores) {
        if (scores.length == 1) {
            return scores[0];
        }
        int[] dp = new int[scores.length];
        dp[0] = scores[0];
        dp[1] = Math.max(scores[0], scores[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + scores[i], dp[i - 1]);
        }
        return dp[scores.length - 1];
    }
}
