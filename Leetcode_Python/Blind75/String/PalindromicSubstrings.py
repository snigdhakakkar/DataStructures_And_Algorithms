#Given a string s, return the number of palindromic substrings in it.
# A string is a palindrome when it reads the same backward as forward.
# A substring is a contiguous sequence of characters within the string.
##time complexity: O(n^2); space complexity: O(1)
class Solution:
    def countSubstrings(self, s: str) -> int:
        result = 0 ##count of palindromic substrings
        
        for i in range(len(s)):
            l = r = i ##taking each element at eahc ith index for odd-length palindromes
            while l >= 0 and r < len(s) and s[l] == s[r]: ##checking if the string is palindromic and within bounds
                result += 1 ##increment the palindrome counter
                l -= 1 ##expanding on both sides
                r += 1
                
            l = i
            r = i + 1 ##modifying the code for even-length palindromes
            while l >= 0 and r < len(s) and s[l] == s[r]:
                result += 1
                l -= 1
                r += 1
                
        return result
##avoiding repetition
class Solution:
    def countSubstrings(self, s: str) -> int:
        result = 0 
        
        for i in range(len(s)):
            result += self.countPalindrome(s, i, i)
            result += self.countPalindrome(s, i, i+1)
                
        return result
    
    def countPalindrome(self, s, l, r):
        result = 0
        while l >= 0 and r < len(s) and s[l] == s[r]:
                result += 1
                l -= 1
                r += 1
        return result