## You are a professional robber planning to rob houses along a street. 
# Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. 
# That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a 
# security system connected, and it will automatically contact the police if two adjacent houses 
# were broken into on the same night.
# Given an integer array nums representing the amount of money of each house, 
# return the maximum amount of money you can rob tonight without alerting the police.

##Approach 1: DP - time complexity: O(N), space complexity: O(1)  
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums is None:
            return 0
        
        if len(nums) == 1:
            return nums[0]
        
        return max(self.rob_simple(nums[:-1]), self.rob_simple(nums[1:]))
    
    def rob_simple(self, nums: List[int]) -> int:
        t1 = 0
        t2 = 0
        for current in nums:
            temp = t1
            t1 = max(current + t2, t1)
            t2 = temp
            
        return t1