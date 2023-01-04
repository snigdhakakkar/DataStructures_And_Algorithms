from typing import List
##Approach 1: using l,r and top, bottom pointers and rotating - time complexity: O(N^2), space complexity: O(1)

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        l,r = 0, len(matrix) - 1
        
        while l < r:
            for i in range(r - l):
                top, bottom = l, r
                
                #save the topleft value
                topLeft = matrix[top][l + i]
                
                #move the bottom left into the topleft vacated position
                matrix[top][l + i] = matrix[bottom - i][l]
                
                #move the bottom right into the bottom left position
                matrix[bottom - i][l] = matrix[bottom][r - i]
                
                #move the top right into the bottom right position
                matrix[bottom][r - i] = matrix[top + i][r]
                
                #move the top left position saved into the top right position
                matrix[top + i][r] = topLeft
                
            r -= 1
            l += 1