package xh.offer.easy;

import java.util.Arrays;

public class offer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            } else {
                if (i == 0 || nums[i - 1] == 0) {
                    continue;
                } else {
                    int diff = nums[i] - nums[i - 1];
                    if (diff == 1) {
                        continue;
                    } else if (diff == 0 || diff > zeroCount + 1) {
                        return false;
                    } else {
                        zeroCount -= (diff - 1);
                    }
                }
            }
        }
        return true;
    }
}
