## Bruteforce approach: Finding subarrays starting with each element: time complexity - O(N^3) 

## Approach 2: Saving the curSum and using it to compute another sum wherein it is a subpart - time complexity: O(N^2)

import math


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_subarray = -math.inf
        for i in range(len(nums)):
            current_subarray = 0
            for j in range(i, len(nums)):
                current_subarray += nums[j]
                max_subarray = max(max_subarray, current_subarray)
        
        return max_subarray

## Approach 3: Ignore negative prefixes. Keep positive prefixes. 

from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxSum = nums[0]
        curSum = 0
        
        for n in nums:
            if curSum < 0:
                curSum = 0
                
            curSum += n
            maxSum = max(maxSum, curSum)
            
        return maxSum

