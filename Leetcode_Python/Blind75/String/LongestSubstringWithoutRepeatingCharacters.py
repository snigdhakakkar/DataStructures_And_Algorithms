## Given a string s, find the length of the longest substring without repeating characters.
## Approach 1: Bruteforce - time complexity - O(n^3), space complexity - O(min(n,m))
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        def check(start, end):
            chars = [0]*128
            for i in range(start, end + 1):
                c = s[i]
                chars[ord(c)] += 1
                if chars[ord(c)] > 1:
                    return False
            return True
        
        n = len(s)
        
        result = 0
        for i in range(n):
            for j in range(i, n):
                if check(i,j):
                    result = max(result, j - i + 1)
                    
        return result