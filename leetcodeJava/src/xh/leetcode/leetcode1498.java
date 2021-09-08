package xh.leetcode;

import java.util.Arrays;

public class leetcode1498 {
    private static final long MOD = 1000000007;

    public int numSubseq(int[] nums, int target) {
        long ans = 0;
        Arrays.sort(nums);
        long[] rs = new long[nums.length];
        rs[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            rs[i] = (rs[i - 1] << 1) % MOD;
        }
        for (int i = 0; i < nums.length; ++i) {
            int l = i;
            int r = nums.length;
            while (r - l > 1) {
                int mid = l + (r - l) / 2;
                if (nums[mid] + nums[i] <= target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (nums[l] + nums[i] <= target) {
                ans = (ans + rs[l - i]) % MOD;
            }
        }
        return (int) ans;
    }
}
