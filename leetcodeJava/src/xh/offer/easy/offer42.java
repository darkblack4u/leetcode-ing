package xh.offer.easy;

public class offer42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp >= 0) {
                dp = dp + nums[i];
            } else {
                dp = nums[i];
            }
            res = Math.max(res, dp);
        }
        return res;
    }
}
