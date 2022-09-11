## Given a string s, find the first non-repeating character in it and return its index. 
# If it does not exist, return -1.

import collections


class Solution:
    def firstUniqChar(self, s: str) -> int:
        ## build hash map : character and how often it appears
        count = collections.Counter(s)
        
        # find the index
        for idx, char in enumerate(s):
            if count[char] == 1:
                return idx
        return -1       