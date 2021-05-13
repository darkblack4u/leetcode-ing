class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int s = n % 2 == 0? (n + 1)/2 : (n + 1)/2 - 1;
        for(int i = 0; i < (n + 1)/ 2; i++){
            for(int j = 0; j < s; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}