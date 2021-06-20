import java.util.*;

public class ali2021TestZiji {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[][] nums = new int[m][2];
            for (int j = 0; j < nums.length; j++) {
                int num = sc.nextInt();
                nums[j][0] = num;
            }
            for (int j = 0; j < nums.length; j++) {
                int num = sc.nextInt();
                nums[j][1] = num;
            }
            System.out.println(method(nums));
        }
        sc.close();
    }

    public static int method(int[][] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i][0] < nums[j][0] && nums[i][1] < nums[j][1])
                        || (nums[i][0] > nums[j][0] && nums[i][1] > nums[j][1]))
                    ret++;
            }
        }
        return ret;
    }
}
