##Given n non-negative integers representing an elevation map where the width of each bar is 1, 
# compute how much water it can trap after raining.

## Approach 1: time complexity: O(n), space complexity: O(n)
# taking two lists for maxLeft and maxRight
# then, taking a list for min(maxLeft, maxRight)
# subtracting height at index i, h[i] from min(maxLeft, maxRight) in another list and 
# summing non-zero values

## Approach 2: time complexity: O(n), space complexity: O(1)
## using two pointers left and right
from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        l, r = 0, len(height) - 1
        leftMax, rightMax = height[l], height[r]
        res = 0
           
        while l<r:
            if leftMax < rightMax:
                l += 1
                leftMax = max(leftMax, height[l])
                res += leftMax - height[l]
            else:
                r -= 1
                rightMax = max(rightMax, height[r])
                res += rightMax - height[r]
                
        return res
