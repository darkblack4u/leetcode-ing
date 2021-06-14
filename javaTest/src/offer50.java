import java.util.*;

public class offer50 {
    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     * 
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
     * 
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue())
                return d.getKey();
        }
        return ' ';
    }
}
