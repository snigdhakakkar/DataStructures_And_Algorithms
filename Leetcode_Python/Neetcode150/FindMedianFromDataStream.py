import heapq


class MedianFinder:
    
    def __init__(self):
        self.small, self.large = [],[]
        #two heaps: large and small, minheap and maxheap
        #heaps should be of equal size
        
    def addNum(self, num: int) -> None:
        heapq.heappush(self.small, -1 * num) #multiplied by -1 to implement maxHeap
        
        #every element in small is less than or equal to every element in the large heap
        if (self.small and self.large and 
            (-1 * self.small[0]) > self.large[0]):
            val = -1 * heapq.heappop(self.small)
            heapq.heappush(self.large, val)
            
        #uneven size
        if len(self.small) > len(self.large) + 1:
            val = -1 * heapq.heappop(self.small)
            heapq.heappush(self.large, val)
            
        if len(self.large) > len(self.small) + 1:
            val = heapq.heappop(self.large)
            heapq.heappush(self.small, -1 * val)
        

    def findMedian(self) -> float:
        if len(self.small) > len(self.large):
            return (-1 * self.small[0])
        
        if len(self.large) > len(self.small):
            return self.large[0]
        
        return ((-1 * self.small[0]) + self.large[0])/2
        


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()