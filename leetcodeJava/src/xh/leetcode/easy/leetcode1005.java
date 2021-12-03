package xh.leetcode.easy;

import java.util.Arrays;

public class leetcode1005 {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 3 };
        int k = 1;
        System.out.println(largestSumAfterKNegations(nums, k));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && i < k) {
                nums[i] = nums[i] * -1;
                count--;
            } else {
                break;
            }
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            if (count % 2 == 1) {
                nums[0] = nums[0] * -1;
            }
        }
        int ret = 0;
        for (int i : nums) {
            System.out.println(i);
            ret += i;
        }
        return ret;
    }
}
