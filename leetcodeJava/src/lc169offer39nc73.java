public class lc169offer39nc73 {
    /**
     * 数组中出现次数超过一半的数字
     * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
     * https://leetcode-cn.com/problems/majority-element/
     * 
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0)
                x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    /**
     * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163
     * 
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int x = 0, votes = 0;
        for (int num : array) {
            if (votes == 0)
                x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
