import java.util.Scanner;

public class lc70offer10B {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numWays(n));
        sc.close();
    }

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
