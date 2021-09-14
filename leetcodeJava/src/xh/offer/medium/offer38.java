package xh.offer.medium;

import java.util.HashSet;

public class offer38 {
    HashSet<String> hs = new HashSet<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] hasProc = new boolean[chars.length];
        StringBuffer sb = new StringBuffer();
        traceBack(chars, hasProc, sb);
        return (String[]) hs.toArray(new String[hs.size()]);
    }

    public void traceBack(char[] chars, boolean[] hasProc, StringBuffer sb) {
        if (sb.length() == chars.length) {
            hs.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasProc[i]) {
                continue;
            }
            hasProc[i] = true;
            sb.append(chars[i]);
            traceBack(chars, hasProc, sb);
            sb.deleteCharAt(sb.length() - 1);
            hasProc[i] = false;
        }
    }
}
