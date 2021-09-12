package xh;

import java.util.Arrays;
import java.util.HashSet;

public class aqiyi1 {
    public static void main(String[] args) {
        System.out.println(calcSumOfOnlyOne(new int[] { 2, 6, 3, 3 }));
    }

    public static int calcSumOfOnlyOne2(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (r - l == 1) {
                return arr[r] + arr[l];
            }
            int mid = (l + r) / 2;
            int left = 0;
            int right = 0;
            for (int i = l; i < mid; i++) {
                left ^= arr[i];
                right ^= arr[i + mid];
            }
            if (left != 0 && right != 0)
                return left + right;
            else if (left == 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public static int calcSumOfOnlyOne(int[] arr) {
        int res = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (hs.contains(arr[i])) {
                res -= arr[i];
            } else {
                res += arr[i];
            }
            hs.add(arr[i]);
        }
        return res;
    }
}
