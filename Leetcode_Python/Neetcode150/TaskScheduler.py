from collections import Counter, deque
import heapq
from typing import List


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        #each task 1 unit time
        #consider n units idle time
        #time complexity: O(n * m) where m is the idle time and n is the count of tasks
        count = Counter(tasks) ##take tasks count
        maxHeap = [-cnt for cnt in count.values()] ##create maxHeap array with negative counts
        heapq.heapify(maxHeap) ##heapify maxHeap array
        
        time = 0 ##initial time
        q = deque() #pair of values: [-cnt, time of availability after idletime]
        
        while maxHeap or q: ##until there are remaining values in heap or queue
            time += 1 ##increment time by 1 unit
            if maxHeap: ##if maxHeap is non-empty
                cnt = 1 + heapq.heappop(maxHeap) ##change the count as we pop
                if cnt:
                    q.append([cnt, time + n]) ##append it to the queue if count is not null
            if q and q[0][1] == time: ##check for time availability in q and if it is equal to current time, push it on to the heap
                heapq.heappush(maxHeap, q.popleft()[0])
                
        return time