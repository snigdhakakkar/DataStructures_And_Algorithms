## Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer 
# (similar to C/C++'s atoi function).
# The algorithm for myAtoi(string s) is as follows:
# Read in and ignore any leading whitespace.
# Check if the next character (if not already at the end of the string) is '-' or '+'. 
# Read this character in if it is either. This determines if the final result is negative or 
# positive respectively. Assume the result is positive if neither is present.
# Read in next the characters until the next non-digit character or the end of the input is reached. 
# The rest of the string is ignored.
# Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). 
# If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
# If the integer is out of the 32-bit signed integer range [-2^31, 23^1 - 1], then clamp the 
# integer so that it remains in the range. Specifically, integers less than -2^31 should be clamped 
# to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.
# 
## Return the integer as the final result.
# Note:
# Only the space character ' ' is considered a whitespace character.
# Do not ignore any characters other than the leading whitespace or the rest of the 
# string after the digits.
   
##TIME COMPLEXITY: O(N) where N is the number of characters ; space complexity: O(1)
class Solution:
    def myAtoi(self, s: str) -> int:
        MAX_INT = 2 ** 31 - 1
        MIN_INT = -2 ** 31
        index = 0
        res = 0
        negative = 1
        
        while index < len(s)  and s[index] == ' ':
            index += 1
            
        if index < len(s) and s[index] == '-':
            index += 1
            negative = -1
        elif index < len(s)  and s[index] == '+':
            index += 1
        
        checker = set('0123456789')
        while index < len(s) and s[index] in checker:
            if res > MAX_INT/10 or (res == MAX_INT/10 and int(s[index]) > 7):
                return MAX_INT if negative == 1 else MIN_INT ##TO HANDLE OVERFLOW OF RES
            res = res * 10 + int(s[index])
            index += 1
        
        res = res * negative
        if res < 0:
            return max(res, MIN_INT)
        return min(res, MAX_INT)