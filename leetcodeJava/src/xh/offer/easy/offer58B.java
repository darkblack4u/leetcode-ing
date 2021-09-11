package xh.offer.easy;

public class offer58B {
    public String reverseLeftWords(String s, int n) {
        if (n == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n, s.length()));
        sb.append(s.substring(0, n));
        return sb.toString();
    }
}
