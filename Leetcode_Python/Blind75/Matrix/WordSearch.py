##Given an m x n grid of characters board and a string word, return true if word exists in the grid.
# The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are 
# horizontally or vertically neighboring. The same letter cell may not be used more than once.

##Approach 1: Backtracking - time complexity: O(N * M * 4^N), space complexity: O(1)

from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])
        path = set() ##record the positions on the board that are on our path to avoid reusing the visited
        
        def dfs(r, c, i):
            if i == len(word):
                return True
            
            if (r < 0 or c < 0 or r >= ROWS or c >= COLS 
                or word[i] != board[r][c] or (r,c) in path):
                return False
            
            path.add((r,c))
            
            result = (dfs(r + 1, c, i + 1) or
                     dfs(r - 1, c, i + 1) or
                     dfs(r, c + 1, i + 1) or 
                     dfs(r, c - 1, i + 1))
        
            path.remove((r,c))   
            return result
        
        for r in range(ROWS):
            for c in range(COLS):
                if dfs(r,c, 0):
                    return True
                
        return False
    