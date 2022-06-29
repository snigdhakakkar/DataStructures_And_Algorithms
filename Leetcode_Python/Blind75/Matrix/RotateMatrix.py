##You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
# You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
# DO NOT allocate another 2D matrix and do the rotation.

##  Approach 1: Rotate groups of 4 cells - time complexity: O(M), space complexity: O(1)
from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix[0])
        for i in range(n // 2 + n % 2):
            for j in range(n//2):
                tmp = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = matrix[i][j]
                matrix[i][j] = tmp

##Approach 2: Using pointers for rotation - time complexity: O(M^2), space complexity: O(1)

class SolutionI:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        l, r = 0, len(matrix) - 1
        while l < r:
            for i in range(r - l):
                top, bottom = l, r
                
                #save the top left value in a temp variable
                topLeft = matrix[top][l + i]
                
                #move the bottom left into top left
                matrix[top][l + i] = matrix[bottom - i][l]
                
                #move the bottom right into bottom left
                matrix[bottom - i][l] = matrix[bottom][r - i]
                
                #move the top right into bottom right
                matrix[bottom][r - i] = matrix[top + i][r]
                
                #move the top left into the top right
                matrix[top + i][r] = topLeft
                
            r -= 1
            l += 1