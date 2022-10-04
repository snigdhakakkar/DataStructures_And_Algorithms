from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        col = set()
        posDiag = set() #r+c is constant in a posDiag
        negDiag = set() #r-c is constant in a negDiag
        
        res = []
        board = [["."]*n for i in range(n)]
        
        def backtrack(r):
            if r==n:
                copy = ["".join(row) for row in board]
                res.append(copy)
                
            for c in range(n):
                if c in col or (r+c) in posDiag or (r-c) in negDiag:
                    continue
                    
                col.add(c)
                posDiag.add(r+c)
                negDiag.add(r-c)
                board[r][c] = "Q"
                    
                backtrack(r + 1)
                
                #cleanup
                col.remove(c)
                posDiag.remove(r+c)
                negDiag.remove(r-c)
                board[r][c] = "."
                
        backtrack(0)
        return res
                
                
                
            
        