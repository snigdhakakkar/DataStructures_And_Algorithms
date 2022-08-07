## Given an array of integers nums and an integer target, return indices of the two numbers 
# such that they add up to target.
# You may assume that each input would have exactly one solution, and you may not use the 
# same element twice. You can return the answer in any order.

from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap ={}
        for i,n in enumerate(nums):
            complement = target - n
            if complement in hashmap:
                return [hashmap[complement], i]
            hashmap[n] = i
        return   