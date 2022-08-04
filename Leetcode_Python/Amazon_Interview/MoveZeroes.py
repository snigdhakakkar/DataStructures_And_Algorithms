## Given an integer array nums, move all 0's to the end of it while maintaining 
# the relative order of the non-zero elements.
# Note that you must do this in-place without making a copy of the array.

## Example:
## Input: nums = [0,1,0,3,12]
## Output: [1,3,12,0,0]

from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        ##Quicksort / quickselect
        l = 0
        for r in range(len(nums)):
            if nums[r]:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
            
        return nums