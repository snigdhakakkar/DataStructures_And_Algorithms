##Given an array of strings strs, group the anagrams together. You can return the answer 
# in any order. An Anagram is a word or phrase formed by rearranging the letters of a 
# different word or phrase, typically using all the original letters exactly once.

import collections
from typing import List

##Approach 1: Sorting and forming a tuple as a key - time complexity: O(NKlogK) 
# where N is the length of the list strs, K is the length of the longest string
# space complexity: O(NK)
def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
            
        return ans.values()

