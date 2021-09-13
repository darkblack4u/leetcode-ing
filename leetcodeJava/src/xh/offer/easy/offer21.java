package xh.offer.easy;

public class offer21 {
    public int[] exchange(int[] nums) {
        int odd = 0;
        int even = nums.length - 1;
        while (odd < even) {
            while (odd < even && nums[odd] % 2 == 1) {
                odd++;
            }
            while (odd < even && nums[even] % 2 == 0) {
                even--;
            }
            if (odd != even) {
                int tmp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = tmp;
            }
        }
        return nums;
    }
}
