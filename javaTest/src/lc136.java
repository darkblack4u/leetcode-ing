public class lc136 {
    /**
     * 136. 只出现一次的数字
     * 
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 
     * https://leetcode-cn.com/problems/single-number/
     * 
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }
}
