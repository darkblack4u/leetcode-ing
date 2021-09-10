package xh.hot100.easy;

import java.util.*;

public class leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] dp = new boolean[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[nums[i] - 1] = true;
        }
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
