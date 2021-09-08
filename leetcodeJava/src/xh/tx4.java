package xh;

import java.util.ArrayList;
import java.util.Scanner;

public class tx4 {
    static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String line = sc.next();
        sc.close();
        if (n < 7)
            System.out.println(0);
        else {
            char[] chars = line.toCharArray();
            int[] dp = new int[n];
            int index = n - 1;
            while (index >= 6 && chars[index] != 'R') {
                index--;
            }
            if (index < 7) {
                System.out.println(0);
            } else {
                int total_r = 0;
                int total_a = 0;
                int total_t = 0;
                int total_s = 0;
                dp[index] = 1;
                while (index >= 0) {
                    if (chars[index] == 'R') {
                        dp[index] = 1;
                        total_r += 1;
                    } else if (chars[index] == 'A') {
                        if (index + 1 < n && chars[index + 1] != 'R') {
                            dp[index] = total_r;
                        } else {
                            dp[index] = total_r - dp[index + 1];
                        }
                        total_a += dp[index];
                    } else if (chars[index] == 'T') {
                        if (index + 1 < n && chars[index + 1] != 'A') {
                            dp[index] = total_r;
                        } else {
                            dp[index] = total_r - dp[index + 1];
                        }
                        total_t += dp[index];
                    } else if (chars[index] == 'S') {
                        if (index + 1 < n && chars[index + 1] != 'T') {
                            dp[index] = total_r;
                        } else {
                            dp[index] = total_r - dp[index + 1];
                        }
                        total_s += dp[index];
                    }
                    index--;
                }
                System.out.println(total_s);
            }
        }
    }
}
