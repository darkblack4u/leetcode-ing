package xh.hot100.easy;

public class leetcode461 {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int res = 0;
        while (diff > 0) {
            res += diff & 1;
            diff >>= 1;
        }
        return res;
    }
}
