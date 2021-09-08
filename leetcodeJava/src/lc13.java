import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 13. 罗马数字转整数 https://leetcode-cn.com/problems/roman-to-integer/
 */
public class lc13 {
    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static void main(String[] string) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}