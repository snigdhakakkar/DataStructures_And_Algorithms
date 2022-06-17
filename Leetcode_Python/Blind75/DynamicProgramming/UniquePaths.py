## There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
# The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
# Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
# The test cases are generated so that the answer will be less than or equal to 2 * 10^9.

## Approach 1: Recursion
def uniquePaths(self, m: int, n: int) -> int:
        if m == 1 or n == 1:
            return 1
        
        return self.uniquePaths(m - 1, n) + self.uniquePaths(m, n - 1)

##Approach 2: DP - time complexity: O(NM), space complexity: O(NM)
def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1]*n for _ in range(m)]
        
        for col in range(1, m):
            for row in range(1, n):
                dp[col][row] = dp[col - 1][row] + dp[col][row - 1]
                
        return dp[m - 1][n - 1]

