package xh.online.disifanshi;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] ls = new int[q];
        int[] rs = new int[q];
        int[] ms = new int[q];

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int m = sc.nextInt();
            ls[i] = l - 1;
            rs[i] = r - 1;
            ms[i] = m;
        }
        System.out.println(generateArray(n, q, ls, rs, ms));
        sc.close();
    }

    private static int generateArray(int n, int q, int[] ls, int[] rs, int[] ms) {
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        boolean[] flag = new boolean[n];
        for (int i = 0; i < q; i++) {
            int l = ls[i];
            int r = rs[i];
            int m = ms[i];
            boolean has = false;
            for (int j = l; j < r + 1; j++) {
                if (!flag[j]) {
                    nums[j] = m;
                    flag[j] = true;
                    has = true;
                } else {
                    if (nums[j] < m) {
                        return -1;
                    } else if (nums[j] == m) {
                        has = true;
                    }
                }
            }
            if (!has)
                return -1;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }
}
