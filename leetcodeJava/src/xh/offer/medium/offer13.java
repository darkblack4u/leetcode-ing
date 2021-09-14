package xh.offer.medium;

import java.util.*;

public class offer13 {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int count = 0;
        boolean[][] dp = new boolean[m][n];
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Queue<Integer> rowSums = new LinkedList<>();
        Queue<Integer> colSums = new LinkedList<>();
        rows.offer(0);
        cols.offer(0);
        rowSums.offer(0);
        colSums.offer(0);

        while (!rows.isEmpty()) {
            int size = rows.size();
            for (int i = 0; i < size; i++) {
                int row = rows.poll();
                int col = cols.poll();
                int rowSum = rowSums.poll();
                int colSum = colSums.poll();

                if (row >= m || col >= n || dp[row][col]) {
                    continue;
                }
                if (rowSum + colSum <= k) {
                    count++;
                    rows.offer(row);
                    cols.offer(col + 1);
                    rowSums.offer(rowSum);
                    colSums.offer((col + 1) % 10 != 0 ? colSum + 1 : colSum - 8);
                    rows.offer(row + 1);
                    cols.offer(col);
                    rowSums.offer((row + 1) % 10 != 0 ? rowSum + 1 : rowSum - 8);
                    colSums.offer(colSum);
                }
                dp[row][col] = true;
            }
        }
        return count;
    }

    public int sum(int m, int n) {
        int sum = 0;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
