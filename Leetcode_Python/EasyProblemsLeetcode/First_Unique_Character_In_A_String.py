#Approach 1: Running through the entire string for checking repition for each character

#time complexity: O(N^2)
#space complexity: O(1)

## this will be a time limit exceeded solution

#Approach 2: Use a Hashmap (dictionary) to map the character of the string with their counts

#time complexity: O(N)
#space complexity: O(N)

import collections


class Solution:
    def firstUniqChar(self, s: str) -> int:
        
        #Build a hashmap for character mapping with their counts
        count = collections.Counter(s)
        
        #find the index 
        for idx, ch in enumerate(s):
            if count[ch] == 1:
                return idx
        return -1