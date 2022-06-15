## Given an array nums containing n distinct numbers in the range [0, n], 
# return the only number in the range that is missing from the array.

##Approach 1: sorting
## time complexity: O(nlogn) dominated by sorting time, space complexity: O(1) if sorted inplace or 
# O(n) if memory allocated for sorting

from typing import List


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()
        
        # Ensure that n is at the last index
        if nums[-1] != len(nums):
            return len(nums)
        
        # Ensure that 0 is at the first index
        elif nums[0] != 0:
            return 0
        
        # If we get here, then the missing number is on the range (0, n)
        for i in range(1, len(nums)):
            expected_num = nums[i - 1] + 1
            if nums[i] != expected_num:
                return expected_num
