public class lc509 {
    /**
     * 509. 斐波那契数 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1
     * 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * 
     * @param n
     * @return
     */
    public int fib(int n) {
        int a = 0;
        int b = 1;
        int r = 0;
        if (n == 0)
            return a;
        if (n == 1)
            return b;
        for (int i = 2; i <= n; i++) {
            r = a + b;
            a = b;
            b = r;
        }
        return r;
    }
}
