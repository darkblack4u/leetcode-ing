package xh.online.tx0926;

import java.util.Scanner;

public class tx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(cut(n, d));
        }
        sc.close();
    }

    private static int cut(int n, int d) {
        double ret = (double) n / 3;
        return ret > d ? 1 : 0;
    }
}
