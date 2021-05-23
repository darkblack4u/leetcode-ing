import java.util.*;

public class lc1707 {
    /**
     * 1707. 与数组中元素的最大异或值
     * https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/
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
