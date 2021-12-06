package xh.leetcode.easy;

public class leetcode1816 {
    public String truncateSentence(String s, int k) {
        char[] ss = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == ' ') {
                count++;
            }
            if (count == k) {
                break;
            }
            sb.append(ss[i]);
        }
        return sb.toString();
    }
}
