import java.util.*;

public class lc342 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(isPowerOfFour(n));
    }

    /**
     * 342. 4的幂
     * 
     * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 
     * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/power-of-four
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param n
     * @return
     */
    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
