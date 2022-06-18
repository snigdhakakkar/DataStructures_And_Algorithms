## You are given an integer array nums. You are initially positioned at the array's first index, 
# and each element in the array represents your maximum jump length at that position.
# Return true if you can reach the last index, or false otherwise.

## Approach 1: Recursion: time complexity - O(2^N), Space complexity - O(N)
from typing import List


def canJump(self, nums: List[int]) -> bool:
        
        
        def canJumpFromPosition(position, nums) -> bool:
            
            if position == len(nums) - 1:
                return True
        
            furthestJump = min((position + nums[position]), (len(nums) - 1))
        
            for nextPosition in range(position + 1, furthestJump + 1, 1):
                if canJumpFromPosition(nextPosition, nums):
                    return True
        
            return False
        return canJumpFromPosition(0, nums)

## Approach 2: mild modification - applying recursion from right to left

def canJump(self, nums: List[int]) -> bool:
        
        
        def canJumpFromPosition(position, nums) -> bool:
            
            if position == len(nums) - 1:
                return True
        
            furthestJump = min((position + nums[position]), (len(nums) - 1))
        
            for nextPosition in range(furthestJump, position, -1):
                if canJumpFromPosition(nextPosition, nums):
                    return True
        
            return False    
        return canJumpFromPosition(0, nums)

