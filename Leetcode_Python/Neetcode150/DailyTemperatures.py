##Time Limit Exceeded - Neetcode approach

from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0]*len(temperatures)
        stack = [] 
        
        for i, t in enumerate(temperatures):
            while stack and t > stack[-1][0]:
                stackT, stackInd = stack.pop()
                res[stackInd] = (i - stackInd)
                
            stack.append([t,i])
            
        return res

##Time limite exceeded: leetcode
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0]*len(temperatures)
        stack = [] 
        
        for curr_day, curr_temp in enumerate(temperatures):
            #pop until the current day's temp is not warmer than the temp at the top of the stack
            while stack and curr_temp > temperatures[stack[-1]]:
                prev_day = stack.pop()
                res[prev_day] = curr_day - prev_day
                
            stack.append(curr_day)
            
        return res