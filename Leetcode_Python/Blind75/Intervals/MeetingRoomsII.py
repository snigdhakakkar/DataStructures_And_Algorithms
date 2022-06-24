##Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], 
# return the minimum number of conference rooms required.

##time complexity: O(nlogn), space complexity: O(n)

from typing import List


def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        start = sorted([i[0] for i in intervals])
        end = sorted([i[1] for i in intervals])
        
        result, count = 0, 0
        s_pointer, e_pointer = 0, 0
        
        while s_pointer < len(intervals):
            if start[s_pointer] < end[e_pointer]:
                s_pointer +=1
                count += 1
            else:
                e_pointer += 1
                count -= 1
            result = max(result, count)
            
        return result