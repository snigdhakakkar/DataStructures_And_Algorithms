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

## Approach 2: sliding window - time complexity: O(n), space complexity: O(min(n,m))
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        chars = [0]*128
        
        left = right = 0
        
        result = 0
        while right < len(s):
            r = s[right]
            chars[ord(r)] += 1
            
            while chars[ord(r)] > 1:
                l = s[left]
                chars[ord(l)] -= 1
                left += 1
                
            result = max(result, right - left + 1)
            
            right += 1
            
        return result
        
##Approach 3: modified sliding window
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()
        
        l = 0
        res = 0
        for r in range(len(s)):
            while s[r] in charSet:
                charSet.remove(s[l])
                l += 1
                
            charSet.add(s[r])
            
            res = max(res, r - l + 1)

        return res