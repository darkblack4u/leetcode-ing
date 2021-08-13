import java.util.Scanner;

public class lc516 {

    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(longestPalindromeSubseq(s));
    }

    /**
     * 516. 最长回文子序列
     * 
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     * 
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     * 
     * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
     * 
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                // System.out.println(i + "," + j + "," + dp[i][j]);
            }
        }
        for (int[] is : dp) {
            for (int is2 : is) {
                System.out.print(is2 + ",");
            }
            System.out.println(";");
        }
        return dp[0][n - 1];
    }
}
