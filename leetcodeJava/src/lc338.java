public class lc338 {
    /**
     * 338. 比特位计数 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * 
     * https://leetcode-cn.com/problems/counting-bits/
     * 
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int count = 0;
        while (count <= n) {
            if (count % 2 == 0) {
                result[count] = result[count >> 1];
            } else {
                result[count] = result[count - 1] + 1;
            }
            count++;
        }
        return result;
    }
}
