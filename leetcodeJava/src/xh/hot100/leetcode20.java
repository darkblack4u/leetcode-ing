package xh.hot100;

import java.util.*;

class leetcode20 {
    public static void main(String[] args) {
        System.out.println(isValid("[[[]"));
    }

    private static final Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put('{', '}');
            put('[', ']');
            put('(', ')');
            put('?', '?');
        }
    };

    public static boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0)))
            return false;
        LinkedList<Character> stack = new LinkedList<Character>() {
            {
                add('?');
            }
        };
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c))
                stack.addLast(c);
            else if (map.get(stack.removeLast()) != c)
                return false;
        }
        return stack.size() == 1;
    }

}