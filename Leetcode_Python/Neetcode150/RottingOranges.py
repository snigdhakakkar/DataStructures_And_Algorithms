from collections import deque
from pip import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #multi-source bfs
        #time complexity: O(m.n) and memory complexity: O(m.n)
        q = deque()
        time, freshOranges = 0, 0
        
        ROWS, COLS = len(grid), len(grid[0])
        
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    freshOranges += 1
                if grid[r][c] == 2:
                    q.append([r,c])
        
        directions = [[0,1], [0,-1], [1,0], [-1,0]]
        while q and freshOranges > 0:
            
            for i in range(len(q)):
                r, c = q.popleft()
                for dr, dc in directions:
                    row, col = r + dr, c + dc
                    #if in bounds and non-rotten fruit, make it rotten
                    if (row < 0 or row == len(grid) or col < 0 or col == len(grid[0]) or
                       grid[row][col] != 1):
                        continue
                    grid[row][col] = 2
                    q.append([row,col])
                    freshOranges -= 1
            time += 1
            
        return time if freshOranges == 0 else -1