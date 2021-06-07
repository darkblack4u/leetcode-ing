public class lc14nc55 {

    /**
     * 14. 最长公共前缀 https://leetcode-cn.com/problems/longest-common-prefix/
     * https://www.nowcoder.com/practice/28eb3175488f4434a4a6207f6f484f47
     * 
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix(String[] strs) {
        // write code here
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < strs[0].length()) {
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index == strs[i].length() || strs[i].charAt(index) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            index++;
        }
        return sb.toString();
    }
}
