## A message containing letters from A-Z can be encoded into numbers using the following mapping:
# 'A' -> "1" , 'B' -> "2" ...'Z' -> "26"
# To decode an encoded message, all the digits must be grouped then mapped back into letters using 
# the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
# "AAJF" with the grouping (1 1 10 6)
# "KJF" with the grouping (11 10 6)
# Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' 
# since "6" is different from "06".
# Given a string s containing only digits, return the number of ways to decode it.
# The test cases are generated so that the answer fits in a 32-bit integer.

## Approach 1: Recursive Approach with Memoization: time complexity - O(N), space complexity - O(N)
from functools import lru_cache


class Solution:
    @lru_cache(maxsize=None)
    def recursiveWithMemo(self, index, s) -> int:
        ##if you have reached the end of the string, return 1 for success
        if index == len(s):
            return 1
        
        #if the string starts with a zero, it cannot be decoded
        if s[index] == '0':
            return 0
        
        if index == len(s) - 1:
            return 1
        
        answer = self.recursiveWithMemo(index + 1, s)
        if int(s[index : index + 2]) <= 26:
            answer += self.recursiveWithMemo(index + 2, s)
            
        return answer
            
        
    def numDecodings(self, s: str) -> int:
        return self.recursiveWithMemo(0,s)

## Approach 2: DP approach: time complexity - O(N), space complexity - O(N)

    def numDecodings(self, s: str) -> int:
        #DP array to store the subproblem results
        dp = [0 for _ in range(len(s) + 1)]
        
        dp[0] = 1
        #ways to decode a string of size 1 is 1; unless the string is '0'
        #0 doesn't have a single digit decode
        dp[1] = 0 if s[0] == '0' else 1
        
        for i in range(2, len(dp)):
            
            #check if successful single digit decode is possible
            if s[i - 1] != '0':
                dp[i] = dp[i - 1]
                
            #check if two digit decode is possible
            two_digit = int(s[i - 2: i])
            if two_digit >= 10 and two_digit <= 26:
                dp[i] += dp[i - 2]
                
        return dp[len(s)]

## Approach 3: DP with space optimization: time complexity - O(N), space complexity - O(1)