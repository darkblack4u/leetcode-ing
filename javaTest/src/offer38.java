import java.util.*;

public class offer38 {
    /**
     * 剑指 Offer 38. 字符串的排列
     * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String[] ss = permutation(s);
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i]);
            System.out.print(" ");
        }
    }

    public static String[] permutation(String s) {
        List<String> ret = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        backTrace(ret, s, sb, new boolean[s.length()]);
        return (String[]) ret.toArray(new String[ret.size()]);
    }

    /**
     * 回溯
     * 
     * @param ret
     * @param s
     * @param sb
     * @param list
     */
    public static void backTrace(List<String> ret, String s, StringBuffer sb, boolean[] list) {
        if (sb.length() == s.length()) {
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (list[i]) {
                continue;
            }
            list[i] = true;
            sb.append(s.substring(i, i + 1));
            backTrace(ret, s, sb, list);
            sb.delete(sb.length() - 1, sb.length());
            list[i] = false;
        }
    }
}
