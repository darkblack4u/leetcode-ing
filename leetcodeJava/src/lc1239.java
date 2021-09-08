import java.util.*;

public class lc1239 {
    /**
     * 1239. 串联字符串的最大长度 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s
     * 中的每一个字符都只出现过一次，那么它就是一个可行解。
     * 
     * 请返回所有可行解 s 中最长长度。
     * 
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param arr
     * @return
     */
    int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }

        backtrack(masks, 0, 0);
        return ans;
    }

    public void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(pos)) == 0) { // mask 和 masks[pos] 无公共元素
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }

    // 作者：LeetCode-Solution
    // 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/solution/chuan-lian-zi-fu-chuan-de-zui-da-chang-d-g6gk/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
