## Given a string s and an integer k, return the length of the longest substring of s 
# that contains at most k distinct characters.

## Approach 1: Sliding window 'Naive approach'

class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        if not s or not k:
            return 0
        
        window = dict()
        max_len = 0
        l = 0
        
        for r, char in enumerate(s): #O(n)
            window[char] = window.get(char, 0) + 1
            while len(window) > k: #O(n)
                window[s[l]] -= 1
                if window[s[l]] == 0:
                    window.pop(s[l])
                    
                l += 1
                
            max_len = max(max_len, r - l + 1)
            
        return max_len

##Approach 2: Optimized
class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        if not s or not k:
            return 0
        
        window = dict()
        max_len = 0
        l = -1
        
        for r, char in enumerate(s): #O(n)
            window[char] = r
            if len(window) > k: #O(k)
                l = min(window.values())
                window.pop(s[l])
                
                
            max_len = max(max_len, r - l)
            
        return max_len