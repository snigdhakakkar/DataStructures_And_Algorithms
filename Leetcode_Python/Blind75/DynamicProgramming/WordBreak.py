## Given a string s and a dictionary of strings wordDict, return true if s can be segmented 
# into a space-separated sequence of one or more dictionary words.
# Note that the same word in the dictionary may be reused multiple times in the segmentation.

##Approach 1: Recursion and backtracking: time complexity - O(2^n) as for a string of length n, there are n+ 1 ways
##At each step we have two choices - to split or not to split
##space complexity: O(n) as the depth of recursion can go up to n 
from collections import deque
from functools import lru_cache
from typing import FrozenSet, List, Set


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        def wordBreakRecurse(s: str, word_dict: Set[str], start: int):
            if start == len(s):
                return True
            
            for end in range(start + 1, len(s) + 1):
                if s[start:end] in word_dict and wordBreakRecurse(s, word_dict, end):
                    return True
                
            return False
        
        return wordBreakRecurse(s, set(wordDict), 0)

##Approach 2: Recursion with memoization: time complexity: O(n^3) as size of recursion tree can go to n^2; space complexity: O(n)
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        @lru_cache
        def wordBreakMemo(s: str, word_dict: FrozenSet[str], start: int):
            if start == len(s):
                return True
            
            for end in range(start+1, len(s) +1):
                if s[start:end] in word_dict and wordBreakMemo(s, word_dict, end):
                    return True
            
            return False
        
        return wordBreakMemo(s, frozenset(wordDict), 0)

##Approach 3: Breadth-first search: time complexity: O(n^3), space complexity: O(n)
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_set = set(wordDict)
        q = deque()
        visited = set()
        
        q.append(0)
        while q:
            start = q.popleft()
            
            if start in visited:
                continue
            
            for end in range(start + 1, len(s) + 1):
                if s[start:end] in word_set:
                    q.append(end)
                    if end == len(s):
                        return True
            visited.add(start)
        return False

##DP Approach
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_set = set(wordDict)
        dp = [False]*(len(s) + 1)
        dp[0] = True
        
        for i in range(1, len(s) + 1):
            for j in range(i):
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break
                    
        return dp[len(s)]