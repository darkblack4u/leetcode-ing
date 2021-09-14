package xh.offer.medium;

public class offer49 {
    public int nthUglyNumber(int n) {
        int pos_two = 0;
        int pos_thr = 0;
        int pos_fiv = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int two = 2 * ugly[pos_two];
        int thr = 3 * ugly[pos_thr];
        int fiv = 5 * ugly[pos_fiv];
        for (int i = 1; i < n; i++) {
            int min = Math.min(two, Math.min(thr, fiv));
            ugly[i] = min;
            if (min == two) {
                two = 2 * ugly[++pos_two];
            }
            if (min == thr) {
                thr = 3 * ugly[++pos_thr];
            }
            if (min == fiv) {
                fiv = 5 * ugly[++pos_fiv];
            }
        }
        return ugly[n - 1];
    }
}
