public class lc121offer63 {
    /**
     * 121. 买卖股票的最佳时机
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * 
     * @param strings
     */
    public static void main(String[] strings) {

    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int min_index = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] - min_index > max) {
                max = prices[i] - min_index;
            } else if (prices[i] - min_index < 0) {
                min_index = prices[i];
            }
        }
        return max;
    }
}
