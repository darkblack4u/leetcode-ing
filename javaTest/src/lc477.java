import java.util.*;

public class lc477 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            // int num = sc.nextInt();
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(totalHammingDistance(nums));
    }

    /**
     * 逐位统计 在计算汉明距离时，我们考虑的是同一比特位上的值是否不同，而不同比特位之间是互不影响的。 对于数组 \textit{nums}nums
     * 中的某个元素 \textit{val}val，若其二进制的第 ii 位为 11，我们只需统计 \textit{nums}nums 中有多少元素的第 ii
     * 位为 00，即计算出了 \textit{val}val 与其他元素在第 ii 位上的汉明距离之和。 具体地，若长度为 nn 的数组
     * \textit{nums}nums 的所有元素二进制的第 ii 位共有 cc 个 11，n-cn−c 个 00，则些元素在二进制的第 ii
     * 位上的汉明距离之和为 c\cdot(n-c) c⋅(n−c) 我们可以从二进制的最低位到最高位，逐位统计汉明距离。将每一位上得到的汉明距离累加即为答案。
     * 具体实现时，对于整数 \textit{val}val 二进制的第 ii 位，我们可以用代码 (val >> i) & 1 来取出其第 ii
     * 位的值。此外，由于10的9次方<2的30次方，我们可以直接从二进制的第 0 位枚举到第 29 位。
     * 
     * @param nums
     * @return
     */
    public static int totalHammingDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}
