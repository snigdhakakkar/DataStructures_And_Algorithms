##Given two strings s and t of lengths m and n respectively, return the minimum 
# window substring of s such that every character in t (including duplicates) is 
# included in the window. If there is no such substring, return the empty string "".
# The testcases will be generated such that the answer is unique.
# A substring is a contiguous sequence of characters within the string.
##Sliding window approach - time complexity: O(N), space complexity: O(N)
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "": ##handlign empty string case
            return ""
        countT, window = {}, {} ##hashmaps for window string, and t string
        
        for c in t:
            countT[c] = 1 + countT.get(c, 0)
            
        result, resLen = [-1, -1], float("infinity")
        l = 0
            
        have, need = 0, len(countT)
        
        for r in range(len(s)):
            c = s[r]
            window[c] = 1 + window.get(c, 0)
            
            if c in countT and window[c] == countT[c]:
                have += 1
                
            while have == need:
                ##update our result
                if (r - l + 1) < resLen:
                    result = [l,r]
                    resLen = (r - l + 1)
                ##pop from the left of the window to get the minimum length window
                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1
                
        l, r = result
        return s[l: r+1] if resLen != float("infinity") else ""