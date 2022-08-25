## You are given an n x n 2D matrix representing an image, 
# rotate the image by 90 degrees (clockwise).
# You have to rotate the image in-place, which means you 
# have to modify the input 2D matrix directly. 
# DO NOT allocate another 2D matrix and do the rotation.

# time complexity: O(n^2), space complexity: O(1)

## Approach 1
from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        self.transpose(matrix)
        self.reflect(matrix)
        
    def transpose(self, matrix):
        n = len(matrix)
        for i in range(n):
            for j in range(i + 1, n):
                matrix[j][i], matrix[i][j] = matrix[i][j], matrix[j][i]
                
    def reflect(self, matrix):
        n = len(matrix)
        for i in range(n):
            for j in range(n//2):
                matrix[i][j], matrix[i][n-j-1] = matrix[i][n-j-1], matrix[i][j]

class SolutionI:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        l, r = 0, len(matrix) - 1
            
        while l < r:
            for i in range(r-l):
                top, bottom = l, r
                
                #save top left value
                topLeft = matrix[top][l + i]
                
                matrix[top][l + i] = matrix[bottom - i][l]
                
                matrix[bottom - i][l] = matrix[bottom][r - i]
                
                matrix[bottom][r - i] = matrix[top + i][r]
                
                matrix[top + i][r] = topLeft
                       
            r -= 1
            l += 1

