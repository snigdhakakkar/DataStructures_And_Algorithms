##Given an integer array nums and an integer k, 
# return the k most frequent elements. You may return the answer in any order.

##bucket sort approach: time complexity: O(n), space complexity: O(n)

import heapq
from collections import Counter
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        freq = [[] for i in range(len(nums)+1)]

        for n in nums:
            count[n] = 1 + count.get(n,0)

        for n,c in count.items:
            freq[c].append(n)

        res = []

        for i in range(len(freq)-1, 0, -1):
            for n in range(freq[i]):
                res.append(n)

                if len(res) == k:
                    return res

##Approach 2:building a heap and converting it into output array
class SolutionI:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]: 
        # O(1) time 
        if k == len(nums):
            return nums

        # 1. build hash map : character and how often it appears
        # O(N) time
        count = Counter(nums)  
        # 2-3. build heap of top k frequent elements and
        # convert it into an output array
        # O(N log k) time
        return heapq.nlargest(k, count.keys(), key = count.get)

        



