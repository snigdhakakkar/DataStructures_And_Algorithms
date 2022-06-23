##Given two strings s and t, determine if they are isomorphic.Two strings s and t are isomorphic 
# if the characters in s can be replaced to get t. All occurrences of a character must be 
# replaced with another character while preserving the order of characters. No two characters may 
# map to the same character, but a character may map to itself.

##Approach 1: Character Mapping with Dictionary
#time complexity: O(N) - We process each character in both the strings 
# exactly once to determine if the strings are isomorphic. 'N' is the length of each string
#space complexity - O(1) - since the size of the ASCII character set is fixed and the keys 
# in our dictionary are all valid ASCII characters according to the problem statement.
def isIsomorphic(self, s: str, t: str) -> bool:
        
        mapping_s_t = {}
        mapping_t_s = {}
        
        for c1, c2 in zip(s,t):
            
            #case 1: no mapping exists in either dictionaries
            if (c1 not in mapping_s_t) and (c2 not in mapping_t_s):
                mapping_s_t[c1] = c2
                mapping_t_s[c2] = c1
                
            #case 2: either mapping doesn't exist in one of the dictionaries or it exists but doesn't match in either of the dictionaries or both
            elif mapping_s_t.get(c1) != c2 or mapping_t_s.get(c2) != c1:
                return False
            
        return True
