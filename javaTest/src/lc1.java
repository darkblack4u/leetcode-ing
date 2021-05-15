import java.util.*;

/**
 * 1. 两数之和 https://leetcode-cn.com/problems/two-sum/
 */
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
