package xh.offer.easy;

import java.util.HashMap;

public class offer50 {
    public char firstUniqChar(String s) {
        char[] ss = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            hm.put(ss[i], hm.getOrDefault(ss[i], 0) + 1);
        }
        for (char c : ss) {
            if (hm.get(c) == 1)
                return c;
        }
        return ' ';
    }
}
