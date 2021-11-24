package xh.leetcode.medium;

import java.util.*;

public class leetcode423 {
    public static void main(String[] args) {
        String s = "owoztneoer";
        System.out.println(originalDigits(s));
    }

    public static String originalDigits(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int[] cnt = new int[10];
        cnt[0] = count.getOrDefault('z', 0);
        cnt[2] = count.getOrDefault('w', 0);
        cnt[4] = count.getOrDefault('u', 0);
        cnt[6] = count.getOrDefault('x', 0);
        cnt[8] = count.getOrDefault('g', 0);

        cnt[3] = count.getOrDefault('h', 0) - cnt[8];
        cnt[5] = count.getOrDefault('f', 0) - cnt[4];
        cnt[7] = count.getOrDefault('s', 0) - cnt[6];

        cnt[1] = count.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = count.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                ans.append((char) (i + '0'));
            }
        }
        return ans.toString();
    }
}
