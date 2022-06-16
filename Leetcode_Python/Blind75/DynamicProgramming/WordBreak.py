## Given a string s and a dictionary of strings wordDict, return true if s can be segmented 
# into a space-separated sequence of one or more dictionary words.
# Note that the same word in the dictionary may be reused multiple times in the segmentation.

##Approach 1: Recursion and backtracking: time complexity - O(2^n) as for a string of length n, there are n+ 1 ways
##At each step we have two choices - to split or not to split
##space complexity: O(n) as the depth of recursion can go up to n 
from typing import List, Set


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