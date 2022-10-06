from pip import List

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        #time complexity: O(m.n)
        #memory complexity: O(m.n) as we are using a hashset visit
        
        ROWS, COLS = len(grid), len(grid[0])
        
        visit = set()
        
        def dfs(r,c):
            if (r < 0 or r == ROWS or c < 0 or c == COLS or grid[r][c] == 0 or
               (r,c) in visit):
                return 0
            visit.add((r,c))
            
            return (1 + dfs(r+1, c)
                   + dfs(r-1, c)
                   + dfs(r, c+1)
                   + dfs(r, c-1))
        
        AREA = 0
        for r in range(ROWS):
            for c in range(COLS):
                AREA = max(AREA, dfs(r,c))
                
        return AREA