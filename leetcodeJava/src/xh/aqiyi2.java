package xh;

import java.util.*;

public class aqiyi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        ArrayList<String> res = calcSumOfOnlyOne(n);
        for (int i = 0; i < res.size(); i++) {
            String line = res.get(i);
            System.out.println(line);
        }
    }

    public static ArrayList<String> calcSumOfOnlyOne(int n) {
        ArrayList<String> ret = new ArrayList<>();
        int m = n / 2;
        for (int i = m; i >= 2; i--) {
            double x = (double) n / (double) i;
            double y = Math.round(x) - x;
            if (i % 2 == 1 && y == 0) {
                StringBuilder sb = new StringBuilder();
                long start = Math.round(x) - i / 2;
                long end = Math.round(x) + i / 2;
                if (start > 0) {
                    for (long j = start; j <= end; j++) {
                        sb.append(j).append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    ret.add(sb.toString());
                }
            } else if (i % 2 == 0 && y == 0.5) {
                long start = Math.round(x) - i / 2;
                long end = Math.round(x) + i / 2 - 1;
                StringBuilder sb = new StringBuilder();
                if (start > 0) {
                    for (long j = start; j <= end; j++) {
                        sb.append(j).append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    ret.add(sb.toString());
                }
            }
        }
        return ret;
    }
}
