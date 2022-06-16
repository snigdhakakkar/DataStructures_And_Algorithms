## Given two strings text1 and text2, return the length of their longest common subsequence. 
# If there is no common subsequence, return 0.
# A subsequence of a string is a new string generated from the original string with 
# some characters (can be none) deleted without changing the relative order of the remaining characters.
# For example, "ace" is a subsequence of "abcde".
# A common subsequence of two strings is a subsequence that is common to both strings.

from functools import lru_cache

class Solution:
    ## MEMOIZATION APPROACH
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        @lru_cache(maxsize=None)
        def memo_solve(p1,p2):
            
            # Base case: If either string is now empty, we can't match
            # up anymore characters.
            if p1 == len(text1) or p2 == len(text2):
                return 0
            
            # Option 1: We don't include text1[p1] in the solution.
            option_1 = memo_solve(p1 + 1, p2)
            
            # Option 2: We include text1[p1] in the solution, as long as
            # a match for it in text2 at or after p2 exists.
            first_occurence = text2.find(text1[p1], p2)
            option_2 = 0
            if first_occurence != -1:
                option_2 = 1 + memo_solve(p1 + 1, first_occurence + 1)
                
            # Return the best option.
            return max(option_1, option_2)
        
        return memo_solve(0,0)
        ## time complexity: O(M.N^2), space complexity: O(M.N)
        
        ##IMPROVED MEMOIZATION

    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        @lru_cache(maxsize=None)
        def memo_solve(p1,p2):
            
            # Base case: If either string is now empty, we can't match
            # up anymore characters.
            if p1 == len(text1) or p2 == len(text2):
                return 0
            
             # Recursive case 1.
            if text1[p1] == text2[p2]:
                return 1 + memo_solve(p1 + 1, p2 + 1)
            
            # Recursive case 2
            else:
                return max(memo_solve(p1, p2+1), memo_solve(p1+1, p2))
        return memo_solve(0,0)

        ## time complexity: O(M.N), space complexity: O(M.N)
    
    ##DP Approach: time complexity: O(M.N), Space complexity: O(M.N)
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        # Make a grid of 0's with len(text2) + 1 columns 
        # and len(text1) + 1 rows.
        dp_grid = [[0] * (len(text2) + 1) for _ in range(len(text1) + 1)]
        
        # Iterate up each column, starting from the last one.
        for col in reversed(range(len(text2))):
            for row in reversed(range(len(text1))):
                # If the corresponding characters for this cell are the same...
                if text2[col] == text1[row]:
                    dp_grid[row][col] = 1 + dp_grid[row + 1][col + 1]
                # Otherwise they must be different...
                else:
                    dp_grid[row][col] = max(dp_grid[row + 1][col], dp_grid[row][col + 1])
        
        # The original problem's answer is in dp_grid[0][0]. Return it.
        return dp_grid[0][0]

    ## Space optimization approach in DP: time complexity: O(MN), space complexity: O(min(M,N))
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        # if text1 doesn't reference the shortest string, swap them
        if len(text2) < len(text1):
            text1, text2 = text2, text1
            
        # The previous column starts with all 0's and like before is 1
        # more than the length of the first word.
        previous = [0]*(len(text1) + 1)
        
        #iterate up each column, starting from the last one
        for col in reversed(range(len(text2))):
            current = [0]*(len(text1) + 1)
            for row in reversed(range(len(text1))):
                if text2[col] == text1[row]:
                    current[row] = 1 + previous[row + 1]
                    
                else:
                    current[row] = max(previous[row], current[row + 1])
                    
            # The current column becomes the previous one.
            previous = current
        # The original problem's answer is in previous[0]. Return it.  
        return previous[0]

    ##another improvised approach
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        # if text1 doesn't reference the shortest string, swap them
        if len(text2) < len(text1):
            text1, text2 = text2, text1
            
        # The previous column starts with all 0's and like before is 1
        # more than the length of the first word.
        previous = [0]*(len(text1) + 1)
        current = [0]*(len(text1) + 1)
        #iterate up each column, starting from the last one
        for col in reversed(range(len(text2))):
            for row in reversed(range(len(text1))):
                if text2[col] == text1[row]:
                    current[row] = 1 + previous[row + 1]
                    
                else:
                    current[row] = max(previous[row], current[row + 1])
                    
            # The current column becomes the previous one, and vice versa.
            previous, current = current, previous
        # The original problem's answer is in previous[0]. Return it.  
        return previous[0]