package xh.hot100.medium;

import java.util.Arrays;

public class leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);
        Arrays.sort(newNums);
        int l = 0;
        int r = nums.length - 1;
        while (l < nums.length && nums[l] == newNums[l]) {
            l++;
        }
        while (l < nums.length && r >= 0 && nums[r] == newNums[r]) {
            r--;
        }
        return r - l + 1;
    }
}
