import heapq
from typing import List


class KthLargest:
    
    def __init__(self, k: int, nums: List[int]):
        #minHeap with k largest elements
        self.minHeap, self.k = nums, k
        heapq.heapify(self.minHeap)
        while len(self.minHeap) > k:
            heapq.heappop(self.minHeap)
        # T: O(nlogn) as creating a min Heap takes O(N) and then getting exactly K 
        # elements requires popping which is (n-k)logn . In worst case sceanrio when 
        # k is very small comparatively, it would nlogn
         

    def add(self,val: int) -> int:
        heapq.heappush(self.minHeap, val)
        if len(self.minHeap) > self.k:
            heapq.heappop(self.minHeap)
            
        return self.minHeap[0]