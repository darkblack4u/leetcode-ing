import java.util.*;

public class offer20 {
    /**
     * 剑指 Offer 20. 表示数值的字符串
     * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isNumber(s));
        sc.close();
    }

    /**
     * 状态
     * 
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        Map[] states = { new HashMap<Character, Integer>() {
            {
                put(' ', 0);
                put('s', 1);
                put('d', 2);
                put('.', 4);
            }
        }, // 0.
                new HashMap<Character, Integer>() {
                    {
                        put('d', 2);
                        put('.', 4);
                    }
                }, // 1.
                new HashMap<Character, Integer>() {
                    {
                        put('d', 2);
                        put('.', 3);
                        put('e', 5);
                        put(' ', 8);
                    }
                }, // 2.
                new HashMap<Character, Integer>() {
                    {
                        put('d', 3);
                        put('e', 5);
                        put(' ', 8);
                    }
                }, // 3.
                new HashMap<Character, Integer>() {
                    {
                        put('d', 3);
                    }
                }, // 4.
                new HashMap<Character, Integer>() {
                    {
                        put('s', 6);
                        put('d', 7);
                    }
                }, // 5.
                new HashMap<Character, Integer>() {
                    {
                        put('d', 7);
                    }
                }, // 6.
                new HashMap<Character, Integer>() {
                    {
                        put('d', 7);
                        put(' ', 8);
                    }
                }, // 7.
                new HashMap<Character, Integer>() {
                    {
                        put(' ', 8);
                    }
                } // 8.
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9')
                t = 'd';
            else if (c == '+' || c == '-')
                t = 's';
            else if (c == 'e' || c == 'E')
                t = 'e';
            else if (c == '.' || c == ' ')
                t = c;
            else
                t = '?';
            if (!states[p].containsKey(t))
                return false;
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
