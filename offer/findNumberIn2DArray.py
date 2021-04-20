class Solution:
    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or len(matrix[0]) == 0: return False
        a = 0
        b = len(matrix[0]) - 1
        while b >= 0 and a < len(matrix):
            if matrix[a][b] == target: return True
            elif matrix[a][b] > target:
                b -= 1
            elif matrix[a][b] < target:
                a += 1
        return False
        
        