package xh.hot100.medium;

import java.util.HashMap;

public class leetcode560 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int pre = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (hm.containsKey(pre - k)) {
                res += hm.get(pre - k);
            }
            hm.put(pre, hm.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}
