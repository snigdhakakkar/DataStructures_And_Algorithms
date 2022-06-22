## There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, 
# and the Atlantic Ocean touches the island's right and bottom edges.
# The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights 
# where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
# The island receives a lot of rain, and the rain water can flow to neighboring cells 
# directly north, south, east, and west if the neighboring cell's height is less than or equal 
# to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
# Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes 
# that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

##Approach 1: BFS - Time complexity - O(M.N), space complexity - O(M.N)
from collections import deque
from typing import List


class SolutionI:
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        
        #checking for empty input array
        if not matrix or not matrix[0]:
            return []
        
        num_rows, num_cols = len(matrix), len(matrix[0])
        
        ##setup each queue with cells adjacent to their respective ocean
        pacific_queue = deque()
        atlantic_queue = deque()
        
        for i in range(num_rows):
            pacific_queue.append((i,0))
            atlantic_queue.append((i, num_cols - 1))
        for i in range(num_cols):
            pacific_queue.append((0,i))
            atlantic_queue.append((num_rows - 1, i))
            
        def bfs(queue):
            reachable = set()
            while queue:
                (row, col) = queue.popleft()
                #this cell is reachable, so mark it
                reachable.add((row,col))
                
                for (x,y) in [(1,0), (0,1), (-1,0), (0, -1)]: ##check in all 4 directions
                    new_row, new_col = row + x, col + y
                    ##check if the new cell is within the bounds
                    if new_row < 0 or new_row >= num_rows or new_col < 0 or new_col >= num_cols:
                        continue
                    ##verify if the cell has not been already visited
                    if (new_row, new_col) in reachable:
                        continue
                        
                    ##check that the new cell has a higher or equal height,
                    ##so that water can flow from the new cell to the old cell
                    if matrix[new_row][new_col] < matrix[row][col]:
                        continue
                        
                    ##if we have come this far, this means the new cell is reachable
                    queue.append((new_row, new_col))
                    
            return reachable
        
        ##perform a BFS for each ocean to find all the cells accessible by each ocean
        pacific_reachable = bfs(pacific_queue)
        atlantic_reachable = bfs(atlantic_queue)
        
        ##determine all the cells which can reach both the oceans, & convert to list
        return list(pacific_reachable.intersection(atlantic_reachable))

## Approach 2: DFS - time complexity: O(M.N), space complexity: O(M.N)

class Solution:
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        
        #checking for empty input array
        if not matrix or not matrix[0]:
            return []
        
        num_rows, num_cols = len(matrix), len(matrix[0])
        
        ##setup each queue with cells adjacent to their respective ocean
        pacific_reachable = set()
        atlantic_reachable = set()
        
        def dfs(row, col, reachable):
            ##this cell is reachable, so mark it
            reachable.add((row, col))
            
            for (x,y) in [(1,0), (-1,0), (0,1), (0,-1)]: #check in all 4 directions
                new_row, new_col = row + x, col + y
                
                ##check if the new cell is within bounds
                if new_row < 0 or new_row >= num_rows or new_col < 0 or new_col >= num_cols:
                    continue
                    
                ##check if the new cell hasn't been already visited
                if (new_row, new_col) in reachable:
                    continue
                    
                # Check that the new cell has a higher or equal height,
                # So that water can flow from the new cell to the old cell
                if matrix[new_row][new_col] < matrix[row][col]:
                    continue
                    
                # If we've gotten this far, that means the new cell is reachable
                dfs(new_row, new_col, reachable)
                
        # Loop through each cell adjacent to the oceans and start a DFS
        for i in range(num_rows):
            dfs(i, 0, pacific_reachable)
            dfs(i, num_cols - 1, atlantic_reachable)
        for i in range(num_cols):
            dfs(0, i, pacific_reachable)
            dfs(num_rows - 1, i, atlantic_reachable)
            
        # Find all cells that can reach both oceans, and convert to list
        return list(pacific_reachable.intersection(atlantic_reachable))
         