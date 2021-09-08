import java.util.*;

public class lc264offer49 {

    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        int pos_two = 0;
        int pos_thr = 0;
        int pos_fiv = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int two = 2 * ugly[pos_two];
            int thr = 3 * ugly[pos_thr];
            int fiv = 5 * ugly[pos_fiv];
            int min = Math.min(two, Math.min(thr, fiv));
            if (min == two)
                pos_two++;
            if (min == thr)
                pos_thr++;
            if (min == fiv)
                pos_fiv++;
            System.out.println(min);
            ugly[i] = min;
        }
        return ugly[n - 1];
    }
}
