import java.util.Scanner;

public class lc461 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(hammingDistance(x, y));
        sc.close();
    }

    /**
     * 461. 汉明距离 https://leetcode-cn.com/problems/hamming-distance/
     * 
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     * 
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     */
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
