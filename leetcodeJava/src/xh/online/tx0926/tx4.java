package xh.online.tx0926;

import java.util.*;

public class tx4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(bfs(t, x - 1, y - 1));
        }
        sc.close();
    }

    private static int bfs(int t, int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        boolean[][] hasReach = new boolean[400][400];
        int ret = 0;
        Queue<Integer> xLine = new LinkedList<>();
        Queue<Integer> yLine = new LinkedList<>();
        xLine.offer(0);
        yLine.offer(0);
        hasReach[0][0] = true;
        int[][] ma = new int[][] { { 2, 1 }, { 2, -1 }, { -2, 1 }, { 1, 2 }, { -1, 2 }, { 1, -2 } };
        int[][] xiang = new int[][] { { 2, 2 }, { 2, -2 }, { -2, 2 } };
        while (!xLine.isEmpty()) {
            int size = xLine.size();
            ret++;
            for (int i = 0; i < size; i++) {
                int tmpX = xLine.poll();
                int tmpY = yLine.poll();
                int newX = tmpX;
                int newY = tmpY;
                if (t == 1 || t == 3) {
                    for (int j = 0; j < ma.length; j++) {
                        newX = tmpX + ma[j][0];
                        newY = tmpY + ma[j][1];
                        if (newX == x && newY == y) {
                            return ret;
                        }
                        if (newX < 0 || newX >= 400 || newY < 0 || newY >= 400 || hasReach[newX][newY]) {
                            continue;
                        } else {
                            hasReach[newX][newY] = true;
                            xLine.offer(newX);
                            yLine.offer(newY);
                        }
                    }
                }
                if (t == 2 || t == 3) {
                    for (int j = 0; j < xiang.length; j++) {
                        newX = tmpX + xiang[j][0];
                        newY = tmpY + xiang[j][1];
                        if (newX == x && newY == y) {
                            return ret;
                        }
                        if (newX < 0 || newX >= 400 || newY < 0 || newY >= 400 || hasReach[newX][newY]) {
                            continue;
                        } else {
                            hasReach[newX][newY] = true;
                            xLine.offer(newX);
                            yLine.offer(newY);
                        }
                    }
                }
            }
        }
        return -1;
    }
}

// 4
// 1 2 3
// 2 3 3
// 3 2 3
// 3 3 3

// 2
// 3 1 2
// 1 2 1
