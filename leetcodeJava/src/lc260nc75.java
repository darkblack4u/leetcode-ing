public class lc260nc75 {
    /**
     * 260. 只出现一次的数字 III
     * 
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     * 
     * https://leetcode-cn.com/problems/single-number-iii/
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            xor ^= nums[i];
        }
        // 寻找二进制中最右边的 1
        xor -= xor & (xor - 1);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            // 根据他们是 1 还是 0，来分配在数组 res 中的位置
            if ((xor & nums[i]) == 0)
                res[0] ^= nums[i];
            else
                res[1] ^= nums[i];
        }
        return res;
    }

    /**
     * https://www.nowcoder.com/practice/389fc1c3d3be4479a154f63f495abff8
     * 
     * @param array
     * @return
     */
    public int[] FindNumsAppearOnce(int[] array) {
        // write code here
        int xor = array[0];
        for (int i = 1; i < array.length; ++i) {
            xor ^= array[i];
        }
        // 寻找二进制中最右边的 1
        xor -= xor & (xor - 1);
        int[] res = new int[2];
        for (int i = 0; i < array.length; ++i) {
            // 根据他们是 1 还是 0，来分配在数组 res 中的位置
            if ((xor & array[i]) == 0)
                res[0] ^= array[i];
            else
                res[1] ^= array[i];
        }
        // 排序
        if (res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }
}