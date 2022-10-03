from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        #TIME COMPLEXITY: O(n2^n) for bruteforce solution. 
        result = []
        
        nums.sort()
        
        def backtrack(i, subset):
            if i == len(nums):
                result.append(subset[::])
                return
                
            #all subsets that include nums[i]
            subset.append(nums[i])
            backtrack(i+1, subset)
            subset.pop()
            
            #all subsets that exclude nums[i]
            while i+1 < len(nums) and nums[i] == nums[i+1]:
                i += 1
            backtrack(i+1, subset)
            
        backtrack(0, [])
        return result