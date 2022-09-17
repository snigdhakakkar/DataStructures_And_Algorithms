from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        #add open parantheses only if open count is less than n
        #add closing parantheses only if close count is less than open
        #valid iff open == close == n
        
        stack = []
        res = []
            
        def backTrack(openN, closeN):
            if openN == closeN == n:
                res.append("".join(stack))
                return
            
            if openN < n:
                stack.append("(")
                backTrack(openN + 1, closeN)
                stack.pop()
                
            if closeN < openN:
                stack.append(")")
                backTrack(openN, closeN + 1)
                stack.pop()