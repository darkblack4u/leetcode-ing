package xh.online.tx0926;

import java.util.Arrays;
import java.util.Scanner;

public class tx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            int num = sc.nextInt();
            a[i] = num;
        }
        System.out.println(minDiff(n, k, a));
        sc.close();
    }

    private static int minDiff(int n, int k, int[] a) {
        if (k == n) {
            return mean(a);
        }
        int maxIndex = 0;
        int minIndex = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                maxIndex = i;
                max = a[i];
            } else if (a[i] < min) {
                minIndex = i;
                min = a[i];
            }
        }
        int start = Math.max(0, Math.min(maxIndex, minIndex) - k + 1);
        int end = Math.max(max, min);
        int l = a[n - 1] - mean(Arrays.copyOfRange(a, 0, k));
        int r = mean(Arrays.copyOfRange(a, n - k, n)) - a[0];
        return l < r ? l : r;
    }

    private static double mean(int[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return (double) sum / (double) a.length;
    }

}
