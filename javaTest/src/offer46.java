import java.util.*;

public class offer46 {

    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(translateNum(num));
    }

    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     * 
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成
     * “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * 
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param num
     * @return
     */
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