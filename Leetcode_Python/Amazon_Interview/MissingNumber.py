## Given an array nums containing n distinct numbers in the range [0, n], return the only 
# number in the range that is missing from the array.

##Approach 1: XOR
from typing import List


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        missing = len(nums)
        for i, num in enumerate(nums):
            missing ^= i ^ num
        return missing

