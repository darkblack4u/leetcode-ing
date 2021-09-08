package xh.hot100;

public class leetcode55 {
    public boolean canJump(int[] nums) {
        boolean[] jump = new boolean[nums.length];
        jump[0] = true;
        int max = 0;
        for (int i = 0; i < jump.length; i++) {
            if (i <= max) {
                max = Math.max(nums[i] + i, max);
                if (max >= nums.length - 1)
                    return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
