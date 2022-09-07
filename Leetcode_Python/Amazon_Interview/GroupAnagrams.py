## Given an array of strings strs, group the anagrams together. You can return the answer 
# in any order. An Anagram is a word or phrase formed by rearranging the letters of a different 
# word or phrase, typically using all the original letters exactly once.

# time complexity: O(m.n) where m is the number of strings given 
# and n is the average length of a string
from collections import defaultdict
from typing import List

   
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list) #mapping the charCount to the list of the anagrams
        
        for s in strs:
            count = [0]*26 #a,b,c....z 
            
            for c in s:
                count[ord(c) - ord("a")] += 1 #bringing the count value in between 0 and 26
            
            res[tuple(count)].append(s) #list cannot be keys, so converted the count list to tuple
            
        return res.values()