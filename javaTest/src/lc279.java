public class lc279 {
    /**
     * 279. 完全平方数 https://leetcode-cn.com/problems/perfect-squares/
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * 
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * 
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        int[] square = new int[(int) Math.sqrt(n) + 1];
        for (int i = 0; i < square.length; i++) {
            square[i] = i * i;
        }
        for (int i = 1; i < n + 1; i++) {
            int min = i;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, nums[i - square[j]] + 1);
            }
            nums[i] = min;
        }
        return nums[n];
    }
}