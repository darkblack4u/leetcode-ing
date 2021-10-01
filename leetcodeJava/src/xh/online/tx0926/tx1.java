package xh.online.tx0926;

import java.util.Scanner;

public class tx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < a.length; j++) {
                int c = sc.nextInt();
                a[j] = c;
            }
            int[] b = new int[n];
            for (int j = 0; j < a.length; j++) {
                int c = sc.nextInt();
                b[j] = c;
            }
            System.out.println(ei(n, k, a, b));
        }
        sc.close();
    }

    private static int ei(int n, int k, int[] a, int[] b) {
        double ei = 0;
        int x = 0, y = 0, z = 0, w = 0;
        for (int i = 0; i < n; i++) {
            int aNum = a[i];
            int bNum = b[i];
            if (aNum == bNum) {
                for (int j = i + 1; j < n; j++) {
                    int aOther = a[j];
                    int bOther = b[j];
                    if (aOther == bOther) {
                        if (aOther == aNum) {
                            x++;
                        } else {
                            w++;
                        }
                    } else {
                        if (aOther == aNum) {
                            y++;
                        } else if (bOther == bNum) {
                            z++;
                        } else {
                            w++;
                        }
                    }
                }
            } else {
                for (int j = i + 1; j < n; j++) {
                    int aOther = a[j];
                    int bOther = b[j];
                    if (aOther == bOther) {
                        if (aOther == aNum) {
                            y++;
                        } else if (bOther == bNum) {
                            z++;
                        } else {
                            w++;
                        }
                    } else {
                        if (aOther == aNum && bOther == bNum) {
                            x++;
                        } else if (aOther == aNum) {
                            y++;
                        } else if (bOther == bNum) {
                            z++;
                        } else {
                            w++;
                        }
                    }

                }
            }
        }
        ei = (double) (x + w) / (double) (x + y + z + w);
        return ei > 0.5 ? 1 : 0;
    }
}
