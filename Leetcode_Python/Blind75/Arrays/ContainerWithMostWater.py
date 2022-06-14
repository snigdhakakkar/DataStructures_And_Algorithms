##You are given an integer array height of length n. 
# There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
# Find two lines that together with the x-axis form a container, 
# such that the container contains the most water.
# Return the maximum amount of water a container can store.
# Notice that you may not slant the container.

##Approach 1: Bruteforce: time complexity: O(N^2), space complexity: O(1)
from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxarea = 0
        
        for left in range(len(height)):
            for right in range(left + 1, len(height)):
                width = right - left
                maxarea = max(maxarea, min(height[left], height[right])*width)
                
        return maxarea

##Approach 2: 2 pointer method: time complexity:O(N)  space complexity: O(1)

    def maxArea(self, height: List[int]) -> int:
        maxarea = 0
        left = 0
        right = len(height) - 1
        
        while left < right:
            width = right - left
            maxarea = max(maxarea, min(height[left], height[right])*width)
            if height[left] <= height[right]:
                left += 1
            else:
                right -= 1
                
        return maxarea
                