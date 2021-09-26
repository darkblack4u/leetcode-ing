package xh.offer.medium;

import java.util.*;

public class offer48 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int l = -1;
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (hm.containsKey(ss[i])) {
                int last = hm.get(ss[i]);
                if (last > l) {
                    l = last;
                }
            }
            ret = Math.max(ret, i - l);
            hm.put(ss[i], i);
        }
        return ret;
    }
}
