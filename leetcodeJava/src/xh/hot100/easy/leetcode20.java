package xh.hot100.easy;

import java.util.*;

public class leetcode20 {
    HashMap<Character, Character> hm = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
            put('?', '?');
        }
    };

    public boolean isValid(String s) {
        Deque<Character> queue = new LinkedList<>();
        queue.add('?');
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (hm.containsKey(ss[i])) {
                queue.offer(ss[i]);
            } else if (hm.get(queue.getLast()) == ss[i]) {
                queue.removeLast();
            } else {
                return false;
            }
        }
        return queue.size() == 1;
    }
}
