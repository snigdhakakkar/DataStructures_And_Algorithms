## Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
# You must do it in place.

## Approach 1: Using additional memory - time complexity - O(MXN), space complexity - O(M + N)
from typing import List

class SolutionI:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        R = len(matrix)
        C = len(matrix[0])
        rows, cols = set(), set()
        
        ##we mark the rows and columns that are to be made zero
        for i in range(R):
            for j in range(C):
                if matrix[i][j] == 0:
                    rows.add(i)
                    cols.add(j)
                    
        ##iterate over the array once more and use the rows and cols sets to update the elements
        for i in range(R):
            for j in range(C):
                if i in rows or j in cols:
                    matrix[i][j] = 0

