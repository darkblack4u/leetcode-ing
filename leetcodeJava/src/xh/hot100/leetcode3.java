package xh.hot100;

import java.util.*;

public class leetcode3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        if (ss.length <= 1)
            return ss.length;
        int res = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int position = -1;
        for (int i = 0; i < ss.length; i++) {
            int pre = hm.getOrDefault(ss[i], -1);
            position = Math.max(position, pre);
            int length = i - position;
            res = Math.max(length, res);
            hm.put(ss[i], i);
        }
        return res;
    }
}
