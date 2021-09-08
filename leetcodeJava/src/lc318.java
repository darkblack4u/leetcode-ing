import java.util.*;

public class lc318 {
    /**
     * 318. 最大单词长度乘积
     * 
     * 给定一个字符串数组 words，找到 length(word[i]) *
     * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
     * 
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int bitNumber(char ch) {
        return (int) ch - (int) 'a';
    }

    public int maxProduct(String[] words) {
        Map<Integer, Integer> hashmap = new HashMap();

        int bitmask = 0, bitNum = 0;
        for (String word : words) {
            bitmask = 0;
            for (char ch : word.toCharArray()) {
                // add bit number bitNumber in bitmask
                bitmask |= 1 << bitNumber(ch);
            }
            // there could be different words with the same bitmask
            // ex. ab and aabb
            hashmap.put(bitmask, Math.max(hashmap.getOrDefault(bitmask, 0), word.length()));
        }

        int maxProd = 0;
        for (int x : hashmap.keySet())
            for (int y : hashmap.keySet())
                if ((x & y) == 0)
                    maxProd = Math.max(maxProd, hashmap.get(x) * hashmap.get(y));

        return maxProd;
    }
}
