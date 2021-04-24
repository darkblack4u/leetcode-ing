class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        if len(grid) == 1: return sum(grid[0])
        if len(grid[0]) == 1: return sum([x[0] for x in grid])
        
        len_y = len(grid[0])
        len_x = len(grid)
        dp = [[0] * len_y] * len_x
        dp[0][0] = grid[0][0]
        for i in range(1, len_x):
            dp[0][i] = dp[0][i - 1] + grid[0][i]
        for i in range(1, len_y):
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        for i in range(1, len_x):
            for j in range(1, len_y):
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        return dp[len_x - 1][len_y - 1]