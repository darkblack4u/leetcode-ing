package xh.hot100.easy;

public class leetcode70 {
    public int climbStairs(int n) {
        if (n <= 3)
            return n;
        int a = 2;
        int b = 3;
        int tmp = a;
        for (int i = 4; i <= n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
