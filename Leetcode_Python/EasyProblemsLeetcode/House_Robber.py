## Recursion with Memoization: time complexity - O(N), space complexity - O(N)

class Solution:
    def __init__(self):
        self.memo = {}
        
        
    def rob(self, nums: List[int]) -> int:
        
        self.memo = {}
        return self.robFrom(0, nums)
    
    def robFrom(self, i, nums):
        
        ##edge case: no more houses left
        if i >= len(nums):
            return 0
        
        #return cached value
        if i in self.memo:
            return self.memo[i]
        
        # Recursive relation evaluation to get the optimal answer.
        ans = max(self.robFrom(i+1, nums), self.robFrom(i+2, nums) + nums[i])
        
        # Cache for future use.
        self.memo[i] = ans
        return ans



## Optimized DP Approach: time complexity - O(N)
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        rob1, rob2 = 0, 0
        
        # [rob1, rob2, n , n+1, n+2, ....]
        for n in nums:
            temp = max(n + rob1, rob2)
            rob1 = rob2
            rob2 = temp
        return rob2