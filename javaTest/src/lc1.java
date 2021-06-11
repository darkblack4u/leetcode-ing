import java.util.*;

public class lc1 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(twoSum(nums, target));
    }

    /**
     * 1. 两数之和 https://leetcode-cn.com/problems/two-sum/
     * 
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 
     * 你可以按任意顺序返回答案。
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int anotherNum = target - nums[i];
            if (map.containsKey(anotherNum)) {
                return new int[] { map.get(anotherNum), i };
            }

            map.put(nums[i], i);
        }
        return new int[0];
    }
}
