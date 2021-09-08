import java.util.*;

public class ali2021TestXQASX {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int nn = sc.nextInt();
        for (int i = 0; i < nn; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(method(a, b, n));
        }
        sc.close();
    }

    public static int method(int a, int b, int n) {
        int mod_num = 1000000007;
        int ret = 0;
        int aa = a;
        int aaa = b;
        for (int i = 2; i < n; i++) {
            ret = a * aaa % mod_num - b * aa % mod_num;
            aa = aaa;
            aaa = ret;
        }
        return ret;
    }
}
