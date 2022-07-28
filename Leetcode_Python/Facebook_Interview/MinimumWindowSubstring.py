## Given two strings s and t of lengths m and n respectively, return the minimum window substring 
# of s such that every character in t (including duplicates) is included in the window. 
# If there is no such substring, return the empty string "".
# The testcases will be generated such that the answer is unique.
# A substring is a contiguous sequence of characters within the string.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "":
            return ""
        
        countT, window = {}, {}
        l = 0
        res, resLen = [-1,-1], float("infinity")
        
        for c in t:
            countT[c] = 1 + countT.get(c, 0)
        
        have, need = 0, len(countT)
        for r in range(len(s)):
            c = s[r]
            window[c] = 1 + window.get(c, 0)
            
            if c in countT and window[c] == countT[c]:
                have += 1
                
            while have == need:
                if (r - l + 1) < resLen:
                    resLen = (r - l + 1)
                    res = [l, r]
                    
                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                    
                l += 1
        l, r = res
        return s[l: r+1] if resLen != float("infinity") else ""
            
                
            
            
        
        