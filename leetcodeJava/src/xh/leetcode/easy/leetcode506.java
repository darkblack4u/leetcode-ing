package xh.leetcode.easy;

import java.util.*;

public class leetcode506 {
    public String[] findRelativeRanks(int[] score) {
        String[] medal = { "Gold Medal", "Silver Medal", "Bronze Medal" };
        String[] ret = new String[score.length];
        int[][] sortScore = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            sortScore[i][0] = score[i];
            sortScore[i][1] = i;
        }
        Arrays.sort(sortScore, (a, b) -> {
            return b[0] - a[0];
        });
        for (int i = 0; i < sortScore.length; i++) {
            if (i < 3) {
                ret[sortScore[i][1]] = medal[i];
            } else {
                ret[sortScore[i][1]] = String.valueOf(i + 1);
            }
        }
        return ret;
    }
}
