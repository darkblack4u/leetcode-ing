class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int a = matrix.length - 1;
        int b = 0;
        while(a >= 0 && b < matrix[0].length && b >= 0){
            if(matrix[a][b] > target){
                a --;
            }else if(matrix[a][b] < target){
                b ++;
            }else if(matrix[a][b] == target){
                return true;
            }
        }
        return false;
    }
}