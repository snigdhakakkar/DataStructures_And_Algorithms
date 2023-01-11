## Bruteforce approach: Finding subarrays starting with each element: time complexity - O(N^3) 

## Approach 2: Saving the curSum and using it to compute another sum wherein it is a subpart - time complexity: O(N^2)

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

