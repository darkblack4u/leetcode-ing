package xh.online.yidongyanjiuyuan;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        StringBuilder out = new StringBuilder();
        out.append("[");
        List<String> ret = function(s);
        for (int i = 0; i < ret.size(); i++) {
            out.append(ret.get(i));
            if (i != ret.size() - 1) {
                out.append(", ");
            }
        }
        out.append("]");
        System.out.println(out.toString());
    }

    private static List<String> function(String s) {
        List<String> ret = new ArrayList<>();
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        StringBuffer sb = new StringBuffer();
        boolean[] has = new boolean[ss.length];
        traceBack(ss, sb, has, ret);
        return ret;
    }

    private static void traceBack(char[] ss, StringBuffer sb, boolean[] has, List<String> ret) {
        if (sb.length() == ss.length) {
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < ss.length; i++) {
            if (has[i]) {
                continue;
            }
            sb.append(ss[i]);
            has[i] = true;
            traceBack(ss, sb, has, ret);
            sb.deleteCharAt(sb.length() - 1);
            has[i] = false;
        }
    }
}
