import java.util.*;

public class lc15 {
    /**
     * 15. 三数之和
     * 
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0
     * 且不重复的三元组。
     * 
     * 注意：答案中不可以包含重复的三元组。 https://leetcode-cn.com/problems/3sum/
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            if (nums[first] > 0) {
                break;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[third] + nums[second];
                if (sum > 0) {
                    while (second < third && nums[third] == nums[--third])
                        ;
                }
                if (sum < 0) {
                    while (second < third && nums[second] == nums[++second])
                        ;
                }
                if (sum == 0) {
                    List<Integer> entity = new ArrayList<Integer>(
                            Arrays.asList(nums[first], nums[second], nums[third]));
                    res.add(entity);
                    while (second < third && nums[third] == nums[--third])
                        ;
                    while (second < third && nums[second] == nums[++second])
                        ;
                }
            }
        }
        return res;
    }
}
