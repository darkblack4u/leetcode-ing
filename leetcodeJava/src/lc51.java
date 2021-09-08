import java.util.ArrayList;
import java.util.List;

public class lc51 {
    List<List<String>> ret = new ArrayList<>();

    /**
     * 51. N 皇后https://leetcode-cn.com/problems/n-queens/
     * 
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        ArrayList<StringBuilder> track = new ArrayList<>();
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                str.append('.');
            }
            track.add(str);
        }
        trackBack(track, 0);
        return ret;
    }

    public void trackBack(ArrayList<StringBuilder> track, int row) {
        // 如果每行都放了Q
        if (row == track.size()) {
            ArrayList<String> a = new ArrayList<>();
            for (StringBuilder sb : track) {
                a.add(sb.toString());
            }
            ret.add(a);
            return;
        }
        int n = track.get(row).length();
        for (int i = 0; i < n; i++) {
            if (!isValid(track, row, i))
                continue;
            track.get(row).setCharAt(i, 'Q');
            trackBack(track, row + 1);
            track.get(row).setCharAt(i, '.');
        }
    }

    // 是否可以在目标位置放皇后
    boolean isValid(ArrayList<StringBuilder> track, int row, int col) {
        int n = track.size();
        // 检查列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if (track.get(i).charAt(col) == 'Q')
                return false;
        }
        // 检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (track.get(i).charAt(j) == 'Q')
                return false;
        }
        // 检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (track.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
}
