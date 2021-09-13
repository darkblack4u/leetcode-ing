package xh.offer.easy;

import java.util.ArrayList;

public class offer57B {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> ret = calcSumOfOnlyOne(target);
        return ret.toArray(new int[ret.size()][]);
    }

    public ArrayList<int[]> calcSumOfOnlyOne(int n) {
        ArrayList<int[]> ret = new ArrayList<>();
        int m = n / 2;
        for (int i = m; i >= 2; i--) {
            double x = (double) n / (double) i;
            double y = Math.round(x) - x;
            if (i % 2 == 1 && y == 0) {
                int start = (int) Math.round(x) - i / 2;
                int end = (int) Math.round(x) + i / 2;
                if (start > 0) {
                    int[] l = new int[end - start + 1];
                    for (int j = start; j <= end; j++) {
                        l[j - start] = j;
                    }
                    ret.add(l);
                }
            } else if (i % 2 == 0 && y == 0.5) {
                int start = (int) Math.round(x) - i / 2;
                int end = (int) Math.round(x) + i / 2 - 1;
                if (start > 0) {
                    int[] l = new int[end - start + 1];
                    for (int j = start; j <= end; j++) {
                        l[j - start] = j;
                    }
                    ret.add(l);
                }
            }
        }
        return ret;
    }
}
