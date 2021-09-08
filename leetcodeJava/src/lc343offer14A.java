import java.util.Scanner;

public class lc343offer14A {
    /**
     * 剑指 Offer 14- I. 剪绳子 https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
     * https://leetcode-cn.com/problems/integer-break/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(cuttingRope(n));
    }

    public static int cuttingRope(int n) {
        if (n < 4)
            return n - 1;
        int ret = 0;
        int a = n % 3;
        int b = n / 3;
        if (a == 1) {
            ret = (int) Math.pow(3, b - 1) * 2 * 2;
        } else if (a == 2) {
            ret = (int) Math.pow(3, b) * 2;
        } else {
            ret = (int) Math.pow(3, b);
        }
        return ret;
    }
}
