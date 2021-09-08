import java.util.Scanner;

public class offer03 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(findRepeatNumber(nums));
    }

    // /**
    // * 数组解法
    // *
    // * @param nums
    // * @return
    // */
    // public static int findRepeatNumber(int[] nums) {
    // int[] count = new int[100001];
    // for (int i = 0; i < nums.length; i++) {
    // if (count[nums[i]] == 1) {
    // return nums[i];
    // }
    // count[nums[i]]++;
    // }
    // return -1;
    // }

    // /**
    // * Hash解法
    // *
    // * @param nums
    // * @return
    // */
    // public static int findRepeatNumber(int[] nums) {
    // HashSet<Integer> hs = new HashSet<>();
    // for (int i = 0; i < nums.length; i++) {
    // if (!hs.add(nums[i])) {
    // return nums[i];
    // }
    // }
    // return -1;
    // }

    /**
     * 原地置换 遍历中，第一次遇到数字 xx 时，将其交换至索引 xx 处；而当第二次遇到数字 xx 时，一定有 nums[x] = xnums[x]=x
     * ，此时即可得到一组重复数字。
     * 
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i])
                return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
