## Given an integer array nums of length n and an integer target, find three integers in nums 
# such that the sum is closest to target.
# Return the sum of the three integers.
# You may assume that each input would have exactly one solution.

from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        distance = float('inf')
        
        for index in range(len(nums) - 2):
            left, right = index + 1, len(nums) - 1
            new_target = target - nums[index]
            while left < right:
                sum_val = nums[left] + nums[right]
                
                if abs(distance) > abs(new_target - sum_val):
                    distance = new_target - sum_val
                
                if sum_val == new_target:
                    return target
                
                elif sum_val < new_target:
                    left += 1
                    
                else:
                    right -= 1
                
        return target - distance