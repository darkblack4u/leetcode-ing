package xh.hot100.medium;

import java.util.*;

public class leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ret = new ArrayList<Integer>();
        backtrace(result, ret, nums);
        return result;
    }

    public void backtrace(List<List<Integer>> result, List<Integer> ret, int[] nums) {
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>(ret));
            return;
        }
        // if(nums.length == 1){
        // ret.add(nums[0]);
        // result.add(new ArrayList<Integer>(ret));
        // return;
        // }
        for (int i = 0; i < nums.length; i++) {
            ret.add(nums[i]);
            backtrace(result, ret, deleteposition(nums, i));
            ret.remove(ret.size() - 1);
        }
    }

    public int[] deleteposition(int[] nums, int position) {
        int[] ret = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i < position) {
                ret[i] = nums[i];
            } else if (i >= position) {
                ret[i] = nums[i + 1];
            }
        }
        return ret;
    }
}
