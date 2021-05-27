import java.util.Scanner;

public class lc461 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(hammingDistance(x, y));
        sc.close();
    }

    public static int hammingDistance(int x, int y) {
        int count = x ^ y;
        int ret = 0;
        while (count > 0) {
            ret += count & 1;
            count >>= 1;
        }
        return ret;
    }

    /**
     * 内置位计数功能
     * 
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
