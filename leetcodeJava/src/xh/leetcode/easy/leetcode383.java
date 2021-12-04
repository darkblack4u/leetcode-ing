package xh.leetcode.easy;

public class leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        int[] rCount = new int[26];
        int[] mCount = new int[26];
        for (char c : r) {
            rCount[c - 'a']++;
        }
        for (char c : m) {
            mCount[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (rCount[i] > mCount[i]) {
                return false;
            }
        }
        return true;
    }
}
