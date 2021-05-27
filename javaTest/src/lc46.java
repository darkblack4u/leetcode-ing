import java.util.Scanner;

public class lc46 {
    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(translateNum(num));
    }

    public static int translateNum(int num) {
        String s = String.valueOf(num);
        char[] ss = s.toCharArray();
        int[] dp = new int[ss.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (ss[i - 2] == '1' || (ss[i - 2] == '2') && ss[i - 1] < '6') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
