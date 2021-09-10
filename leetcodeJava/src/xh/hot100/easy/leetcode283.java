package xh.hot100.easy;

public class leetcode283 {
    public void moveZeroes(int[] nums) {
        int zero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zero >= 0) {
                    swap(nums, i, zero);
                    for (int j = zero + 1; j <= i; j++) {
                        if (nums[j] == 0) {
                            zero = j;
                            break;
                        }
                    }
                }
            } else {
                if (zero < 0) {
                    zero = i;
                }
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
