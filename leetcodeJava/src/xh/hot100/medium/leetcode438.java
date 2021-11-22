package xh.hot100.medium;

import java.util.*;

public class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] ps = p.toCharArray();
        char[] ss = s.toCharArray();
        if (ss.length < ps.length) {
            return new ArrayList<Integer>();
        }
        int[] p_count = new int[26];
        int[] s_count = new int[26];
        List<Character> lost = new ArrayList<>();
        List<Character> more = new ArrayList<>();
        for (int i = 0; i < ps.length; i++) {
            lost.add(ps[i]);
            int p_index = ps[i] - 'a';
            p_count[p_index]++;
            // int s_index = ss[i] - 'a';
            // s_count[s_index]++;
        }
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < ss.length; i++) {
            if (i >= ps.length) {
                if (check(p_count, s_count)) {
                    ret.add(i - ps.length);
                }
                int s_index = ss[i - ps.length] - 'a';
                s_count[s_index]--;
            }
            int s_index = ss[i] - 'a';
            s_count[s_index]++;
        }
        return ret;
    }

    private boolean check(int[] p_count, int[] s_count) {
        for (int i = 0; i < s_count.length; i++) {
            if (p_count[i] != s_count[i])
                return false;
        }
        return true;
    }
}
