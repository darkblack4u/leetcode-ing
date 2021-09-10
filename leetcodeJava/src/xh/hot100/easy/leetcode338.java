package xh.hot100.easy;

public class leetcode338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = res[i >> 1];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}
