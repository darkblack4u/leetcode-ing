package xh.offer.easy;

public class offer57A {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[] { nums[i], nums[j] };
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] { -1, -1 };
    }
}
