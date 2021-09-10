package xh.hot100.hard;

public class leetcode42 {
    public static void main(String[] args) {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int[] l = new int[height.length];
        int[] r = new int[height.length];
        int lmax = height[0];
        int rmax = height[height.length - 1];
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            lmax = Math.max(lmax, height[i - 1]);
            l[i] = lmax;
            rmax = Math.max(rmax, height[height.length - i]);
            r[height.length - i - 1] = rmax;
        }
        for (int i = 1; i < r.length - 1; i++) {
            int lr = Math.min(l[i], r[i]);
            if (lr > height[i]) {
                res += (lr - height[i]);
            }
        }
        return res;
    }
}