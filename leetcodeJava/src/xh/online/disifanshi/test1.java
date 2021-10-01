package xh.online.disifanshi;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            int num = sc.nextInt();
            nums[i] = num;
        }
        System.out.println(kth(n, k, nums));
        sc.close();
    }

    private static int kth(int n, int k, int[] nums) {
        if (n == 1) {
            return nums[0];
        }
        if (n == k) {
            return Math.min(nums[0], nums[nums.length - 1]);
        }
        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        int ret = 0;
        while (l <= k && count < n - k + 1) {
            if (nums[l] > nums[r]) {
                ret = nums[r];
                r--;
            } else if (nums[l] < nums[r]) {
                ret = nums[l];
                l++;
            } else {
                r--;
                l++;
            }
            count++;
        }
        Arrays.sort(nums);
        return nums[n - k];
    }
}
