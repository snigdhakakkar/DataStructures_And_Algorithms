from typing import List


class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pair = [[p,s] for p, s in zip(position, speed)] 
        stack = [] #length of stack in the end will give the number of fleets
        
        for p, s in sorted(pair)[::-1]: #reverse sorted order
            stack.append((target - p) / s)
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                stack.pop()
                
        return len(stack)