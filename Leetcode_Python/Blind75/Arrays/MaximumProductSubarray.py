## Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
# The test cases are generated so that the answer will fit in a 32-bit integer. A subarray is a contiguous subsequence of the array.

from typing import List

## time complexity: O(N^2), Space complexity: O(1)
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        result = nums[0]
        
        for i in range(len(nums)):
            accumulator = 1
            for j in range(i, len(nums)):
                accumulator *= nums[j]
                result = max(result, accumulator)
                
        return result   