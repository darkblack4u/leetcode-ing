import java.util.Scanner;

public class lc29offer001A {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println(divide(a, b));
    }

    /**
     * 剑指 Offer II 001. 整数除法
     * 
     * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
     * 
     * @param a
     * @param b
     * @return
     */
    public static int divide(int a, int b) {
        if (a == 0)
            return 0;
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        boolean f = (a > 0 && b > 0) || (a < 0 && b < 0) ? true : false;
        long x = Math.abs((long) a), y = Math.abs((long) b);
        long ans = 0;
        for (int i = 31; i >= 0; i--) {
            if ((x >> i) >= y) {
                ans += ((long) 1 << i);
                x -= (y << i);
            }
        }
        return f ? (int) ans : (int) (-ans);
    }
}