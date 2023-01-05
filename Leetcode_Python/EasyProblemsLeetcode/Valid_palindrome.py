##Approach 1: Use space for new string and built-in functions
class Solution:
    def isPalindrome(self, s: str) -> bool:
        newStr = ""
        
        for c in s:
            if c.isalnum():
                newStr = newStr + c.lower()
        return newStr == newStr[::-1]

## Approach 2: Two pointer approach
# time complexity: O(N)
# space complexity: O(1)

class Solution:
    def isPalindrome(self, s: str) -> bool:
        ## two pointer approach
        l, r = 0, len(s)-1
        while l < r:
            while l < r and not self.alphanum(s[l]):
                l += 1
            
            while r > l and not self.alphanum(s[r]):
                r -= 1
                
            if s[l].lower() != s[r].lower():
                return False
            
            l += 1
            r -= 1
            
        return True
        
        
        
    def alphanum(self, c):
        if (ord('A') <= ord(c) <= ord('Z') or 
            ord('a') <= ord(c) <= ord('z') or
            ord('0') <= ord(c) <= ord('9')
           ):
            return True
        return False