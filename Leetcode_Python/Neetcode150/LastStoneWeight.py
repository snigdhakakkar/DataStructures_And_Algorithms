import heapq
from typing import List
#there is no maxHeap in Python thus we would use minHeap to simulate 
# maxheap and we would make all the values negative to do that

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        # Time complexity: O(nlogn) : as it takes O(n) to construct a heap 
        # and then O(logn) to get the largest value from it and we have to do it n 
        # time until the last stone is left. So, O(nlogn)
        
        stones = [-s for s in stones]
        heapq.heapify(stones)
        
        while len(stones) > 1:
            first = heapq.heappop(stones)
            second = heapq.heappop(stones)
            if second > first:
                heapq.heappush(stones, first - second)
        
        stones.append(0) #to handle the  case when there are no stones left
        return abs(stones[0])