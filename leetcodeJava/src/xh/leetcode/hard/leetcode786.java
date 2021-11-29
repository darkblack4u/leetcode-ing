package xh.leetcode.hard;

public class leetcode786 {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 5 };
        int k = 3;
        System.out.println(kthSmallestPrimeFraction(arr, k));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x, y) -> arr[x[0]] * arr[y[1]] - arr[y[0]] * arr[x[1]]);
        for (int j = 1; j < n; ++j) {
            pq.offer(new int[]{0, j});
        }
        for (int i = 1; i < k; ++i) {
            int[] frac = pq.poll();
            int x = frac[0], y = frac[1];
            if (x + 1 < y) {
                pq.offer(new int[]{x + 1, y});
            }
        }
        return new int[]{arr[pq.peek()[0]], arr[pq.peek()[1]]};
    }
}
