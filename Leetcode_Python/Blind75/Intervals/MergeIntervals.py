##Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
# and return an array of the non-overlapping intervals that cover all the intervals in the input.

from typing import List


def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        ##sorting the entire input
        intervals.sort(key = lambda i : i[0])
        output = [intervals[0]]
        
        for start, end in intervals[1 : ]:
            lastEnd = output[-1][1]
            
            if start <= lastEnd:
                output[-1][1] = max(output[-1][1], end)
                # [1,5] [2,4] ; [1,4][2,5]
            else:
                output.append([start, end])
        return output