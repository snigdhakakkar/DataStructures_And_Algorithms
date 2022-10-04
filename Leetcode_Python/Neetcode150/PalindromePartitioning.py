from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        #bruteforce - backtracking approach: time complexity: O(2^n)
        res = []
        part = [] #currentpartition
        
        def dfs(i):
            if i >= len(s):
                res.append(part.copy())
                return
            
            for j in range(i, len(s)):
                if self.isPali(s, i, j):#check if s is a palindrome starting from index i to j
                    part.append(s[i:j+1])
                    dfs(j + 1)
                    part.pop() #cleaning up
                    
        dfs(0)
        return res
    
    def isPali(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l, r = l + 1, r - 1
            
        return True