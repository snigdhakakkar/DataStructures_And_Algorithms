## Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
# A subarray is a contiguous part of an array

import math
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_subArray_sum = -math.inf
        
        for i in range(len(nums)):
            current_subarray_sum = 0
            
            for j in range(i, len(nums)):
                current_subarray_sum += nums[j]
                max_subArray_sum = max(max_subArray_sum, current_subarray_sum)
                
        return max_subArray_sum

