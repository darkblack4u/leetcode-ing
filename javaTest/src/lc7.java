public class lc7 {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(x);
        int symbol = 1;
        if (x < 0) {
            sb.append(s.substring(1));
            symbol = -1;
        } else {
            sb.append(s);
        }
        return symbol * Integer.valueOf(sb.reverse().toString());
    }
}
