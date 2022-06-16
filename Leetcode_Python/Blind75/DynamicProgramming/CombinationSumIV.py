## Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
# The test cases are generated so that the answer can fit in a 32-bit integer.

from functools import lru_cache
from typing import List

##Top-Down DP Approach: time complexity: O(T.N) in worst-case scenario; space complexity: O(T)
def combinationSum4(self, nums: List[int], target: int) -> int:
        
        @lru_cache(maxsize = None)
        def combs(remain):
            if remain == 0:
                return 1
            
            result = 0
            for num in nums:
                if remain - num >= 0:
                    result += combs(remain - num)
                    
            return result
        
        return combs(target)

##DP Bottom-up approach: time complexity: O(T.N), space complexity: O(T)

def combinationSum4(self, nums: List[int], target: int) -> int:
        dp = [0 for i in range(target + 1)]
        dp[0] = 1
        
        for comb_sum in range(target+1):
            
            for num in nums:
                if comb_sum - num >= 0:
                    dp[comb_sum] += dp[comb_sum - num]
                    
        return dp[target]