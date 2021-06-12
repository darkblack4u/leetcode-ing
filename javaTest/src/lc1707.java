import java.util.*;

public class lc1707 {
    /**
     * 1707. 与数组中元素的最大异或值
     * https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/
     * 
     * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
     * 
     * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR
     * xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
     * 
     * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i
     * 个查询的答案。
     * 
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param strings
     */
    public static void main(String[] strings) {

    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int qn = queries.length;
        int[] ret = new int[qn];
        List<Integer> newnums = new ArrayList<>();
        Arrays.sort(nums);
        newnums.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                newnums.add(nums[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            int max = -1;
            int v = queries[i][0];
            int a = queries[i][1];
            for (int j = 0; j < newnums.size(); j++) {
                if (newnums.get(j) <= a) {
                    max = Math.max(max, newnums.get(j) ^ v);
                } else {
                    break;
                }
            }
            ret[i] = max;
        }
        return ret;
    }
}
