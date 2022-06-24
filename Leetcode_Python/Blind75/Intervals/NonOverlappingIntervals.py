## Given an array of intervals intervals where intervals[i] = [starti, endi], 
# return the minimum number of intervals you need to remove to make the rest of the 
# intervals non-overlapping.

from typing import List

##approach: sort and compare - time complexity : O(nlogn)
def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort() ##sorting - we can also specify sorting key as start or end
        
        result = 0 ##number of intervals to be deleted to make it non-overlapping
        prevEnd = intervals[0][1] ##initalize the prevEnd of the first interval after sorting
        
        for start, end in intervals[1:]: ##iterate over the intervals
            if start >= prevEnd: ##there is no overlap
                prevEnd = end ##update the prevEnd to be compared for the next interval
            else:
                result += 1 ##there is an overlap so an interval needs to be removed 
                prevEnd = min(end, prevEnd) ##we would remove the one with larger end point, and thus keep the min endpoint one
                
        return result

