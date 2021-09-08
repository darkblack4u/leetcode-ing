package xh.hot100.easy;

import java.util.*;

public class leetcode1 {
    public static void main(String[] strings) {
        // Scanner sc = new Scanner(System.in);
        // int size = sc.nextInt();
        // int[] nums = new int[size];
        // for (int i = 0; i < size; i++) {
        // nums[i] = sc.nextInt();
        // }
        // int target = sc.nextInt();
        // sc.close();
        int[] result = twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (hm.containsKey(another)) {
                return new int[] { hm.get(another), i };
            }
            hm.put(nums[i], i);
        }
        return new int[] { 0, 0 };
    }
}