public class lc55 {
    /**
     * 55. 跳跃游戏
     * 
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 
     * 判断你是否能够到达最后一个下标。
     * 
     * 
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        for (int i = 0; i < length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= length - 1) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
