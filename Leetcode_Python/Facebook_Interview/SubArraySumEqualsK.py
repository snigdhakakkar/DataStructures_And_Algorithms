## Given an array of integers nums and an integer k, return the total number of subarrays 
# whose sum equals to k.
# A subarray is a contiguous non-empty sequence of elements within an array.

from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0 ##number of contiguous subarrays
        curSum = 0 ##current sum
        prefixSums = {0: 1} ##adding a default prefix sum vavlue of 0 with count 1
        
        for n in nums:
            curSum += n
            diff = curSum - k
            
            res += prefixSums.get(diff, 0)
            prefixSums[curSum] = 1 + prefixSums.get(curSum, 0)
            
        return res
        

