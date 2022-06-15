## Given an integer array nums, return the length of the longest strictly increasing subsequence.
# A subsequence is a sequence that can be derived from an array by deleting some or 
# no elements without changing the order of the remaining elements. 
# For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

##DP Approach: time complexity: O(N^2), space complexity: O(N)
from typing import List


def lengthOfLIS(self, nums: List[int]) -> int:
        
        dp = [1]*len(nums)
        
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    
        return max(dp)

## Approach 2: 