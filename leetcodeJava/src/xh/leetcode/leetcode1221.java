package xh.leetcode;

import java.util.*;

public class leetcode1221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.close();
    }

    public int balancedStringSplit(String s) {
        char[] ss = s.toCharArray();
        int r = 0;
        int l = 0;
        int res = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == 'R')
                r += 1;
            else {
                l += 1;
            }
            if (r == l) {
                res++;
            }
        }
        return res;
    }
}