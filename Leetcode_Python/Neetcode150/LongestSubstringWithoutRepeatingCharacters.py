class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()
        res = 0
        left_ptr = 0
        
        for right_ptr in range(len(s)):
            while s[right_ptr] in charSet:
                charSet.remove(s[left_ptr])
                left_ptr += 1
                
            charSet.add(s[right_ptr])
            res = max(res, right_ptr - left_ptr + 1)
            
        return res