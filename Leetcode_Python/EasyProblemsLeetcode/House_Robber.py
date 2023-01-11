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