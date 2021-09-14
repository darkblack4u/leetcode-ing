package xh.offer.medium;

public class offer16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1 || x == 0) {
            return x;
        }
        if (x == -1) {
            return n % 2 == 1 ? -1 : 1;
        }
        double ret = 1.0;
        int times = Math.abs(n);
        for (int i = 0; i < times; i++) {
            ret = ret * x;
        }
        return n > 0 ? ret : 1 / ret;
    }
}
