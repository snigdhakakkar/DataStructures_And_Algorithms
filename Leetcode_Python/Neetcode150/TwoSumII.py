from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l, r = 0, len(numbers) - 1
        
        while l < r:
            currentSum = numbers[l] + numbers[r]
            
            if currentSum > target:
                r -= 1
            
            elif currentSum < target:
                l += 1
                
            else :
                return [l + 1,r + 1]