##Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        myset = set()
        
        for i in range(len(nums)):
            
            if nums[i] in myset:
                return True
        
            myset.add(nums[i])
        
        
        return False

    ###time complexity: O(n) and space complexity: O(n)