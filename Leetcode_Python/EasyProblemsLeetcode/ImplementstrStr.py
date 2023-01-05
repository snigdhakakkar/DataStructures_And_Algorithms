##ClarificationQuestion: What should we do if it is an empty string

# time complexity: O(n*m)
# space complexity: O(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle=="":
            return -1
        
        for i in range(len(haystack) + 1 - len(needle)):
            for j in range(len(needle)):
                if haystack[i+j] != needle[j]:
                    break
                if j == len(needle) - 1:
                    return i
                
        return -1
