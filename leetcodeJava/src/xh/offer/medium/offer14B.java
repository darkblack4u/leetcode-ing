package xh.offer.medium;

public class offer14B {
    public int cuttingRope(int n) {
        if (n < 4)
            return n - 1;
        long ret = 1;
        int a = n % 3;
        int b = n / 3;
        if (a == 1) {
            for (int i = 0; i < b - 1; i++) {
                ret = ret * 3 % 1000000007;
            }
            ret = ret * 2 % 1000000007;
            ret = ret * 2 % 1000000007;
        } else if (a == 2) {
            for (int i = 0; i < b; i++) {
                ret = ret * 3 % 1000000007;
            }
            ret = ret * 2 % 1000000007;
        } else {
            for (int i = 0; i < b; i++) {
                ret = ret * 3 % 1000000007;
            }
        }
        return (int) ret;
    }
}
