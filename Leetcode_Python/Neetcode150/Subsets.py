from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        #worstcase time complexity for bruteforce approach: O(n2^n)
        
        #we will use backtracking here
        res = []
        
        subset = [] #subset that we currently have
        
        def dfs(i): #i is the index of the value that we are making a decision on
            if i >= len(nums):
                res.append(subset.copy())
                return
            
            #decision to include nums[i]
            subset.append(nums[i])
            dfs(i + 1)
            
            #decision not to include nums[i] in our subset
            subset.pop()
            dfs(i + 1)
            
        dfs(0)
        return res