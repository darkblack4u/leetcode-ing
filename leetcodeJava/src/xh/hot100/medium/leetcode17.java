package xh.hot100.medium;

import java.util.*;

public class leetcode17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> hp = new HashMap<>();
        hp.put('2', "abc");
        hp.put('3', "def");
        hp.put('4', "ghi");
        hp.put('5', "jkl");
        hp.put('6', "mno");
        hp.put('7', "pqrs");
        hp.put('8', "tuv");
        hp.put('9', "wxyz");
        StringBuffer sb = new StringBuffer();
        List<String> result = new ArrayList<String>();
        if (digits.equals(""))
            return result;
        back(digits, result, 0, sb, hp);
        return result;
    }

    public void back(String digits, List<String> result, int flag, StringBuffer sb, HashMap<Character, String> hp) {
        if (flag == digits.length()) {
            result.add(sb.toString());
        } else {
            char a = digits.charAt(flag);
            String value = hp.get(a);
            for (int i = 0; i < value.length(); i++) {
                String b = value.substring(i, i + 1);
                sb.append(b);
                back(digits, result, flag + 1, sb, hp);
                sb.delete(flag, flag + 1);
            }
        }
    }
}
