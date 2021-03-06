## You are a professional robber planning to rob houses along a street. 
# Each house has a certain amount of money stashed, the only constraint stopping you from robbing 
# each of them is that adjacent houses have security systems connected and it will automatically 
# contact the police if two adjacent houses were broken into on the same night.
# Given an integer array nums representing the amount of money of each house, 
# return the maximum amount of money you can rob tonight without alerting the police.

##Approach 1: Recursion with memoization: time complexity: O(N), space complexity: O(N)
from typing import List


class Solution:
    def __init__(self):
        self.memo = {}
        
    def rob(self, nums: List[int]) -> int:
        
        self.memo ={}
        
        return self.robFrom(0, nums)
    
    def robFrom(self, i, nums):
        
        # No more houses left to examine.
        if i >= len(nums):
            return 0
        
        # Return cached value.
        if i in self.memo:
            return self.memo[i]
        
        # Recursive relation evaluation to get the optimal answer.
        ans = max(self.robFrom(i + 1, nums), self.robFrom(i + 2, nums) + nums[i])
        
        #cache for future use.
        self.memo[i] = ans
        return ans

## Approach 2: DP bottom-up approach: time complexity - O(N), space complexity - O(N)
    def rob(self, nums: List[int]) -> int:
        
        #handling edge case: empty array
        if not nums:
            return 0
        
        maxRobbedAmount = [0 for _ in range(len(nums) + 1)]
        N = len(nums)
        
        #base case initialization
        maxRobbedAmount[N], maxRobbedAmount[N - 1] = 0, nums[N - 1]
        
        #DP table calculations
        for i in range(N-2, -1, -1):
            
            maxRobbedAmount[i] = max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i])
            
        return maxRobbedAmount[0]

## Approach 3: DP with space optimization: time complexity: O(N), space complexity: O(1)

def rob(self, nums: List[int]) -> int:
        
        #handling edge case: empty array
        if not nums:
            return 0
        N = len(nums)
        #base case initialization
        rob_next_plus_one = 0 ##no house left for stealing
        rob_next = nums[N - 1] ##only the last house left for stealing
        
        
        #DP table calculations
        for i in range(N-2, -1, -1):
            
            current = max(rob_next, rob_next_plus_one + nums[i])
            
            # Update the variables
            rob_next_plus_one = rob_next
            rob_next = current
            
        return rob_next

