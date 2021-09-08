import java.util.*;

public class lc773 {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[2][3];
        board[0][0] = sc.nextInt();
        board[0][1] = sc.nextInt();
        board[0][2] = sc.nextInt();
        board[1][0] = sc.nextInt();
        board[1][1] = sc.nextInt();
        board[1][2] = sc.nextInt();
        sc.close();
        System.out.println(slidingPuzzle(board));
    }

    /**
     * 773. 滑动谜题
     * 
     * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
     * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换. 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
     * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 来源：力扣（LeetCode
     * 链接：https://leetcode-cn.com/problems/sliding-puzzle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param board
     * @return
     */
    public static int slidingPuzzle(int[][] board) {
        HashSet<String> hs = new HashSet<>();
        // hs.add(toAString(board));
        Queue<int[][]> queue = new LinkedList<>();
        int ret = 0;
        queue.offer(board);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[][] nums = queue.poll();
                String n = toAString(nums);
                if (n.equals("123450")) {
                    return ret;
                }
                if (hs.contains(n)) {
                    continue;
                } else {
                    hs.add(n);
                    int[] ij = findZero(nums);
                    int i = ij[0];
                    int j = ij[1];
                    if (i - 1 >= 0)
                        queue.offer(swap(nums, i, j, i - 1, j));
                    if (j - 1 >= 0)
                        queue.offer(swap(nums, i, j, i, j - 1));
                    if (j + 1 < 3)
                        queue.offer(swap(nums, i, j, i, j + 1));
                    if (i + 1 < 2)
                        queue.offer(swap(nums, i, j, i + 1, j));
                }
            }
            ret++;
        }
        return -1;
    }

    public static String toAString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        sb.append(board[0][0]);
        sb.append(board[0][1]);
        sb.append(board[0][2]);
        sb.append(board[1][0]);
        sb.append(board[1][1]);
        sb.append(board[1][2]);
        return sb.toString();
    }

    public static int[][] swap(int[][] board, int i, int j, int i1, int j1) {
        int[][] ret = new int[2][3];
        for (int k = 0; k < board.length; k++) {
            for (int k2 = 0; k2 < board[0].length; k2++) {
                ret[k][k2] = board[k][k2];
            }
        }
        int tmp = ret[i][j];
        ret[i][j] = ret[i1][j1];
        ret[i1][j1] = tmp;
        return ret;
    }

    public static int[] findZero(int[][] board) {
        for (int k = 0; k < board.length; k++) {
            for (int k2 = 0; k2 < board[0].length; k2++) {
                if (board[k][k2] == 0)
                    return new int[] { k, k2 };
            }
        }
        return new int[] { 1, 2 };
    }
}
