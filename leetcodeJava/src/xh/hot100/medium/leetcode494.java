package xh.hot100.medium;

public class leetcode494 {
    int a = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backTrace(nums, target, 0);
        return a;
    }

    public void backTrace(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0)
                ++a;
            return;
        }
        backTrace(nums, target - nums[index], index + 1);
        backTrace(nums, target + nums[index], index + 1);
        return;
    }
}
