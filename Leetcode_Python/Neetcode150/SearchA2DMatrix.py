from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])
        
        top, bottom = 0, ROWS - 1
        while top <= bottom:
            row = top + (bottom - top) // 2
            if target > matrix[row][-1]:
                top = row + 1
            elif target < matrix[row][0]:
                bottom = row - 1
            else:
                break
        
        if not (top <= bottom):
            return False
        
        row = top + (bottom - top) // 2
        
        l, r = 0, COLS - 1
        while l <= r:
            pivot = l + (r - l) // 2
            if target > matrix[row][pivot]:
                l = pivot + 1
            elif target < matrix[row][pivot]:
                r = pivot - 1
            else:
                return True
        return False