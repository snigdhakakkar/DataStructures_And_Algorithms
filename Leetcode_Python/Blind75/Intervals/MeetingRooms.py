## Given an array of meeting time intervals where intervals[i] = [starti, endi], 
# determine if a person could attend all meetings.

##Bruteforce approach
from typing import List


def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        def overlap(interval1: List[int], interval2: List[int]) -> bool:
            return (min(interval1[1], interval2[1]) > max(interval1[0], interval2[0]))
        
        for i in range(len(intervals)):
            for j in range(i+1, len(intervals)):
                if overlap(intervals[i], intervals[j]):
                    return False
        return True

##sorting
def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        intervals.sort()
        
        for i in range(len(intervals) - 1):
            if intervals[i][1] > intervals[i + 1][0]:
                return False
        return True