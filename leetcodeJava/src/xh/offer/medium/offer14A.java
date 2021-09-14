package xh.offer.medium;

public class offer14A {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int res = 1;
        while (n > 0) {
            if (n == 4) {
                res *= 4;
                n -= 4;
            } else if (n == 2) {
                res *= 2;
                n -= 2;
            } else {
                res *= 3;
                n -= 3;
            }
        }
        return res;
    }
}
