##Approach 1: Use space for new string and built-in functions
class Solution:
    def isPalindrome(self, s: str) -> bool:
        newStr = ""
        
        for c in s:
            if c.isalnum():
                newStr = newStr + c.lower()
        return newStr == newStr[::-1]