## Given two strings s and t, return true if s is a subsequence of t, or false otherwise. 
# A subsequence of a string is a new string that is formed from the original string by 
# deleting some (can be none) of the characters without disturbing the relative positions of the 
# remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

##Approach 1: Divide and conquer with greedy - time complexity: O(T), space complexity: O(T) where T is 
#the length of the target string
import bisect
from collections import defaultdict


def isSubsequence(self, s: str, t: str) -> bool:
        LEFT_BOUND, RIGHT_BOUND = len(s), len(t) ##defining the end limits for both the strings

        def rec_isSubsequence(left_index, right_index):
            # base cases
            if left_index == LEFT_BOUND: ##string source if completely found in the target string
                return True
            if right_index == RIGHT_BOUND: ##target string got exhausted without finding the complete source string
                return False
            # consume both strings or just the target string
            if s[left_index] == t[right_index]: ##the character at left index is same for both source & target
                left_index += 1 ##can cross the matching index character and search for the rest
            right_index += 1 ##the left_index character does not match, so just cross that character 
            #in the target string and search for complete source string in the remaining target string

            return rec_isSubsequence(left_index, right_index) ##recursive

        return rec_isSubsequence(0, 0) ##starting with 0th index for both source and target

##Approach 2: Two pointer approach: time complexity: O(T), space complexity: O(1)

def isSubsequence(self, s: str, t: str) -> bool:
        LEFT_BOUND, RIGHT_BOUND = len(s), len(t) ##defining the end limits for both the strings

        p_left = p_right = 0 ##INITIALIZE THE TWO POINTERS
        while p_left < LEFT_BOUND and p_right < RIGHT_BOUND: ##while the strings have not been exhausted
            ##move both the pointers or just the right pointer
            if s[p_left] == t[p_right]:
                p_left += 1 ##increment the left pointer (source string)
            p_right += 1 ##increment the right pointer (target string)
            
        return p_left == LEFT_BOUND ##if the source string has been found completely or not

##Follow up question: If there are lots of incoming S, say S_1, ..., and you want to check 
# one by one to see if T has its subsequence. In this scenario, how would you change your code?

##Approach : Greedy match with character indices hashmap
## time complexity: O(T + SlogT), space complexity: O(T)
def isSubsequence(self, s: str, t: str) -> bool:
        
        letter_indices_table = defaultdict(list)
        for index, letter in enumerate(t):
            letter_indices_table[letter].append(index)
            
        curr_match_index = -1
        for letter in s:
            if letter not in letter_indices_table: 
                return False #no match at all, early exit
            
            ##greedy match with binary search
            indices_list = letter_indices_table[letter]
            match_index = bisect.bisect_right(indices_list, curr_match_index)
            if match_index != len(indices_list):
                curr_match_index = indices_list[match_index]
            else:
                return False #no suitable match found, early exit
            
        return True

##Approach 2: DP - time complexity = space complexity = O(S.T)

def isSubsequence(self, s: str, t: str) -> bool:
        
        source_len, target_len = len(s), len(t)
        
        #the source string is empty
        if source_len == 0:
            return True
        
        ##matrix to store the history of matches / deletions
        dp = [[0] * (target_len + 1) for _ in range(source_len + 1)]
        
        ##DP compute, we fill the matrix col by col, bottom up
        for col in range(1, target_len + 1):
            for row in range(1, source_len + 1):
                if s[row - 1] == t[col - 1]:
                    ##found another match
                    dp[row][col] = dp[row - 1][col - 1] + 1
                else:
                    ##retrieve the maximal result from previous prefixes
                    dp[row][col] = max(dp[row][col - 1], dp[row - 1][col])
                    
            ##check if we can consume the entire source string, with the current
            ## prefix of the target string
            if dp[source_len][col] == source_len:
                return True
            
        return False

