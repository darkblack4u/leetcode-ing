import java.util.HashMap;
import java.util.Scanner;

public class offer10A {
    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(fib(n));
    }

    // static HashMap<Integer, Integer> count = new HashMap<>();

    // public static int fib(int n) {
    // if (n == 0)
    // return 0;
    // else if (n == 1)
    // return 1;
    // if (count.containsKey(n)) {
    // return count.get(n);
    // } else {
    // int num = (fib(n - 2) % 1000000007 + fib(n - 1) % 1000000007) % 1000000007;
    // count.put(n, num);
    // return num;
    // }
    // }

    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
