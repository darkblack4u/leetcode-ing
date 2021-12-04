package xh.leetcode.easy;

public class leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        if (r.length > m.length) {
            return false;
        }
        int[] count = new int[26];
        for (char c : m) {
            count[c - 'a']++;
        }
        for (char c : r) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
