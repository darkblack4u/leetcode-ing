package xh.hot100.medium;

import java.util.Arrays;

public class leetcode128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Arrays.sort(nums);
        int max = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                len += 1;
            } else if (nums[i] - nums[i - 1] > 1) {
                len = 1;
            }
            max = Math.max(len, max);
        }
        return max;
    }
}
