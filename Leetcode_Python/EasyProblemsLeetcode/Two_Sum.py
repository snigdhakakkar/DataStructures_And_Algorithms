# time complexity: O(N)
# space complexity: O(N)

from typing import List
##bruteforce approach
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if(nums[j] == target - nums[i]):
                    return [i,j]
##time complexity: O(n^2) and space complexity: O(1)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prevMap = {} # hashmap to record value : index
        
        for i, n in enumerate(nums):
            diff = target - n
            if diff in prevMap:
                return [prevMap[diff], i]
            prevMap[n] = i
            
        return

