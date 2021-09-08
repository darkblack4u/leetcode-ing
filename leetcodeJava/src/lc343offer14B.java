import java.util.Scanner;

public class lc343offer14B {
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
