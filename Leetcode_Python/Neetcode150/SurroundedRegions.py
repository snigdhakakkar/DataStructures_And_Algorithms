from pip import List


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        ROWS, COLS = len(board), len(board[0])
        
        #capture unsurrounded regions (o -> t)
        def capture(r,c):
            if (r < 0 or r == ROWS or c < 0 or c == COLS or board[r][c] != "O"):
                return 
            board[r][c] = "T"
            capture(r + 1, c)
            capture(r - 1, c)
            capture(r, c + 1)
            capture(r, c - 1)
            
        for r in range(ROWS):
            for c in range(COLS):
                if (board[r][c] == "O" and (r in [0, ROWS - 1] or c in [0, COLS - 1])):
                    capture(r,c)
        
        #capture surrounded regions (nested for loops o -> x)
        for r in range(ROWS):
                for c in range(COLS):
                    if board[r][c] == "O":
                        board[r][c] = "X"

        #uncapture unsurrounded regions (t -> o)
        for r in range(ROWS):
                for c in range(COLS):
                    if board[r][c] == "T":
                        board[r][c] = "O"
        