from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        maxArea = 0 #maximum area of rectangle
        stack = [] #pair: index, height
        
        for i, h in enumerate(heights): 
            start = i #right now, we are not extending backwards
            while stack and stack[-1][1] > h:
                index, height = stack.pop()
                maxArea = max(maxArea, height * (i - index))
                start = index #since, current height being added is less than the one popped
            stack.append((start, h))
        
        for i, h in stack:
            maxArea = max(maxArea, h * (len(heights) - i))
        return maxArea