import java.util.*;

public class lc3offer48 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
        sc.close();
    }

    /**
     * 3. 无重复字符的最长子串
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     */
    public static int lengthOfLongestSubstring(String s) {
        int positon = 0;
        int maxlength = 0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            String letter = s.substring(i, i + 1);
            if (hm.containsKey(letter)) {
                int preIndex = hm.get(letter);
                if (positon <= preIndex) {
                    positon = preIndex;
                }
            }
            if (i - positon + 1 > maxlength) {
                maxlength = i - positon + 1;
            }
            hm.put(letter, i + 1);
        }
        return maxlength;
    }
}
