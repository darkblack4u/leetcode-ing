package xh.offer.medium;

public class offer66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0)
            return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
