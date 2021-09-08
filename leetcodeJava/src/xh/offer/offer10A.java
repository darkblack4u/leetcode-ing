package xh.offer;

public class offer10A {
    public int fib(int n) {
        if (n < 2)
            return n;
        int mod = 1000000007;
        int fst = 0;
        int scd = 1;
        int tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = (scd + fst) % mod;
            fst = scd;
            scd = tmp;
        }
        return scd;
    }
}
