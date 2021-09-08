package xh.hot100;

import java.util.*;

public class leetcode448 {
    public static void main(String[] args) {
        int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDisappearedNumbers(nums));
        nums = new int[] { 1, 1 };
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 把相应的nums中的数对应的-1下标位置，乘以-1 表明这个下标也就是这个数出现过了
            if (nums[Math.abs(nums[i]) - 1] > 0)
                nums[Math.abs(nums[i]) - 1] *= -1;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }
}
