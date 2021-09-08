package xh;

import java.util.*;

public class tx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String line;
        char[][] br = new char[n][m];
        for (int i = 0; i < br.length; i++) {
            line = sc.next();
            br[i] = line.toCharArray();
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        int res = 0;
        x--;
        y--;
        boolean[][] has = new boolean[n][m];
        has[x][y] = true;
        Queue<Integer> queue_x = new LinkedList<>();
        Queue<Integer> queue_y = new LinkedList<>();
        queue_x.offer(x);
        queue_y.offer(y);
        boolean isRed;
        while (!queue_x.isEmpty()) {
            int size = queue_x.size();
            res += size;
            for (int i = 0; i < size; i++) {
                int cur_x = queue_x.poll();
                int cur_y = queue_y.poll();
                isRed = br[cur_x][cur_y] == 'r' ? true : false;
                int next_x = cur_x - 1;
                int next_y = cur_y - 2;
                if (next_x >= 0 && next_y >= 0) {
                    if (!has[next_x][next_y]) {
                        if ((isRed && br[next_x][next_y] == 'b') || (!isRed && br[next_x][next_y] == 'r')) {
                            queue_x.offer(next_x);
                            queue_y.offer(next_y);
                            has[next_x][next_y] = true;
                        }
                    }
                }
                next_x = cur_x - 2;
                next_y = cur_y - 1;
                if (next_x >= 0 && next_y >= 0) {
                    if (!has[next_x][next_y]) {
                        if ((isRed && br[next_x][next_y] == 'b') || (!isRed && br[next_x][next_y] == 'r')) {
                            queue_x.offer(next_x);
                            queue_y.offer(next_y);
                            has[next_x][next_y] = true;
                        }
                    }
                }
                next_x = cur_x + 2;
                next_y = cur_y - 1;
                if (next_x < br.length && next_y >= 0) {
                    if (!has[next_x][next_y]) {
                        if ((isRed && br[next_x][next_y] == 'b') || (!isRed && br[next_x][next_y] == 'r')) {
                            queue_x.offer(next_x);
                            queue_y.offer(next_y);
                            has[next_x][next_y] = true;
                        }
                    }
                }
                next_x = cur_x + 1;
                next_y = cur_y - 2;
                if (next_x < br.length && next_y >= 0) {
                    if (!has[next_x][next_y]) {
                        if ((isRed && br[next_x][next_y] == 'b') || (!isRed && br[next_x][next_y] == 'r')) {
                            queue_x.offer(next_x);
                            queue_y.offer(next_y);
                            has[next_x][next_y] = true;
                        }
                    }
                }
                next_x = cur_x + 2;
                next_y = cur_y + 1;
                if (next_x < br.length && next_y < br[0].length) {
                    if (!has[next_x][next_y]) {
                        if ((isRed && br[next_x][next_y] == 'b') || (!isRed && br[next_x][next_y] == 'r')) {
                            queue_x.offer(next_x);
                            queue_y.offer(next_y);
                            has[next_x][next_y] = true;
                        }
                    }
                }
                next_x = cur_x + 1;
                next_y = cur_y + 2;
                if (next_x < br.length && next_y < br[0].length) {
                    if (!has[next_x][next_y]) {
                        if ((isRed && br[next_x][next_y] == 'b') || (!isRed && br[next_x][next_y] == 'r')) {
                            queue_x.offer(next_x);
                            queue_y.offer(next_y);
                            has[next_x][next_y] = true;
                        }
                    }
                }
                next_x = cur_x - 1;
                next_y = cur_y + 2;
                if (next_x >= 0 && next_y < br[0].length) {
                    if (!has[next_x][next_y]) {
                        if ((isRed && br[next_x][next_y] == 'b') || (!isRed && br[next_x][next_y] == 'r')) {
                            queue_x.offer(next_x);
                            queue_y.offer(next_y);
                            has[next_x][next_y] = true;
                        }
                    }
                }
                next_x = cur_x - 2;
                next_y = cur_y + 1;
                if (next_x >= 0 && next_y < br[0].length) {
                    if (!has[next_x][next_y]) {
                        if ((isRed && br[next_x][next_y] == 'b') || (!isRed && br[next_x][next_y] == 'r')) {
                            queue_x.offer(next_x);
                            queue_y.offer(next_y);
                            has[next_x][next_y] = true;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
