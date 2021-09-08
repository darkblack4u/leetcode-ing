import java.util.*;

public class ali2021Test1 {
    /**
     * 【2021】阿里巴巴编程题1
     * 
     * 有个物品，每个物品有个属性，第件物品的第个属性用一个正整数表示记为，两个不同的物品被称为是完美对的当且仅当，求完美对的个数。
     * 
     * 第一行两个数字。
     * 
     * 接下来行，第行个数字表示。
     * 
     * 
     * 
     * https://www.nowcoder.com/test/question/done?tid=45012632&qid=1664808
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] nums = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int num = in.nextInt();
                nums[i][j] = num;
            }
        }
        in.close();
        System.out.println(method(nums, n, k));

    }

    public static int method(int[][] nums, int n, int k) {
        int ret = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (dp[i] > 0) {
                continue;
            }
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (dp[j] > 0) {
                    continue;
                }
                int sum = nums[i][0] + nums[j][0];
                int index = 1;
                for (; index < k; index++) {
                    if (nums[i][index] + nums[j][index] != sum) {
                        break;
                    }
                }
                if (index == k) {
                    count++;
                    dp[j] = count;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            ret += dp[i];
        }
        return ret;
    }
}
