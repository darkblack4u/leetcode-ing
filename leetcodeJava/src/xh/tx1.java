package xh;

import java.util.Scanner;

public class tx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            w[i] = num;
        }
        int[] A = new int[m];
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            A[i] = num;
        }
        sc.close();
        for (int i = 0; i < m; i++) {
            System.out.println("-1 -1");
        }
    }
}
