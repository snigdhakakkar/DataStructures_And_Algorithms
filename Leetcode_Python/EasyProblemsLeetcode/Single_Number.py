##Approach: Using XOR property - bit manipulation
## time complexity: O(1)
## space complexity: O(1)

from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        
        for i in nums:
            res = res ^ i
        return res