from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        #TIME COMPLEXITY: O(2^n)
        candidates.sort()
        result = []
        
        def backtrack(cur, pos, target):
            if target == 0:
                result.append(cur.copy())
                
            if target <= 0:
                return
            
            prev = -1
            for i in range(pos, len(candidates)):
                if candidates[i] == prev:
                    continue
                
                cur.append(candidates[i])
                backtrack(cur, i+1, target - candidates[i] )
                cur.pop()
                
                prev = candidates[i]
                
                
        backtrack([], 0, target)
        return result
                
                