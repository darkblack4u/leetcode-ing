package xh.hot100;

public class leetcode11 {
    public static void main(String[] args) {
        int[] height = new int[] { 1, 1 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        int h = 0;
        while (l < r) {
            h = Math.min(height[l], height[r]);
            res = Math.max(res, h * (r - l));
            if (h == height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
