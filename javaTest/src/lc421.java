import java.util.*;

public class lc421 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        int ret = 0;
        return ret;
    }
}
