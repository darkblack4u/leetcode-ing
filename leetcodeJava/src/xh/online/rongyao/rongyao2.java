package xh.online.rongyao;

import java.util.*;

public class rongyao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();
        System.out.println(diff(a, b));
    }

    private static char diff(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        if (b.length() == 0) {
            return aChar[0];
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < bChar.length; i++) {
            hm.put(bChar[i], hm.getOrDefault(bChar[i], 0) + 1);
        }
        for (int i = 0; i < aChar.length; i++) {
            if (hm.containsKey(aChar[i])) {
                int count = hm.get(aChar[i]);
                if (count == 1) {
                    hm.remove(aChar[i]);
                } else {
                    hm.put(aChar[i], count - 1);
                }
            } else {
                return aChar[i];
            }
        }
        return 'a';
    }
}
