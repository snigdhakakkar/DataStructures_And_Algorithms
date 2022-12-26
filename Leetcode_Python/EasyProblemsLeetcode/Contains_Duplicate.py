from typing import List

##Approach 1: use a hashSet
##time complexity: O(N)
##space complexity: O(N)
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        hashSet = set()
        
        for i in nums:
            if i in hashSet:
                return True
            hashSet.add(i)
            
        return False

##Approach 2: Sorting
##time complexity: O(NlogN)
##space complexity: O(1)