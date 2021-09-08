import java.util.*;

public class lc313 {
    /**
     * 313. 超级丑数 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
     * 
     * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
     * 
     * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
     * 
     * https://leetcode-cn.com/problems/super-ugly-number/
     */

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m]; // 系数，用于确保primes*dp[系数]<dp[当前]，如果primes*dp[系数]==dp[当前]，说明此primes这一次被选择了，系数要转到下一个
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[m]; // 维护当前要比较的num，用于提醒最小项的系数更新。
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (minNum == nums[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }
}
