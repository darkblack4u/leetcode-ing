import java.util.*;

public class lc5 {
    /**
     * 5. 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
     * 
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == "" || s.length() == 1)
            return s;
        int max = 0;
        String sb = "";
        for (int i = 0; i < s.length() - 1; i++) {
            int length = 1;
            String subS = s.substring(i, i + 1);
            String a = sub(s, i, i); // 自己没有回文
            String b = sub(s, i, i + 1); // 自己有回文
            if (a.length() > b.length()) {
                length = a.length();
                subS = a;
            } else {
                length = b.length();
                subS = b;
            }
            if (length > max) {
                max = length;
                sb = subS;
            }
        }
        return sb;
    }

    public static String sub(String s, int left, int right) {
        if (left != right && s.charAt(left) != s.charAt(right)) {
            return s.substring(left, right);
        }
        int start = left;
        int end = right;
        for (int i = 1; i <= left && i <= s.length() - 1 - right; i++) {
            if (s.charAt(left - i) == s.charAt(right + i)) {
                start--;
                end++;
            } else {
                break;
            }
        }
        return s.substring(start, end + 1);
    }
}