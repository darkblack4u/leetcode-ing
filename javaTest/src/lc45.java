public class lc45 {
    /**
     * 45. 跳跃游戏 II
     * 
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 
     * 假设你总是可以到达数组的最后一个位置。
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (maxPosition >= length - 1) {
                steps++;
                break;
            }
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
