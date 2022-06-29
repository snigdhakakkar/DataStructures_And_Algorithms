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

##Approach 2: backtracking - time complexity: O(N.3^L), space complexity: O(L) where L is the length of the string
class Solution(object):
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.ROWS, self.COLS = len(board), len(board[0])
        self.board = board
        
        for r in range(self.ROWS):
            for c in range(self.COLS):
                if self.dfs(r,c, word):
                    return True
                
        return False
    
    def dfs(self, r, c, suffix):
        if len(suffix) == 0:
            return True
            
        if (r < 0 or c < 0 or r >= self.ROWS or c >= self.COLS 
            or self.board[r][c] != suffix[0]):
            return False
        
        result = False
        # mark the choice before exploring further.
        self.board[r][c] = '#'
        
        # explore the 4 neighbor directions
        for rowOffset, colOffset in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
            result = self.dfs(r + rowOffset, c + colOffset, suffix[1:])
            # break instead of return directly to do some cleanup afterwards
            if result:
                return True
                
        #revert the change, a clean slate and no side-effect
        self.board[r][c] = suffix[0]
        
        return result