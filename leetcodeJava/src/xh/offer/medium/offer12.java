package xh.offer.medium;

public class offer12 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] chars, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != chars[k]) {
            return false;
        }
        if (k == chars.length - 1)
            return true;
        board[i][j] = '\0';
        boolean ret = dfs(board, chars, i + 1, j, k + 1) || dfs(board, chars, i, j + 1, k + 1)
                || dfs(board, chars, i - 1, j, k + 1) || dfs(board, chars, i, j - 1, k + 1);
        board[i][j] = chars[k];
        return ret;
    }
}
