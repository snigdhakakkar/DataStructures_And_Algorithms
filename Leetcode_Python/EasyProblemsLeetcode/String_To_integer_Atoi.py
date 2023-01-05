class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip()
        
        ##handling the edge case wherein after removing empty spaces there is no string left
        if not s:
            return 0
        
        if len(s)==1 and not s[0].isdigit():
            return 0
        
        i = 0
        sign = 1 #1 if positive , -1 if negative
        
        if s[i] == "+":
            i += 1
        elif s[i] == "-" :
            i += 1
            sign = -1
            
            
        INT_MAX = pow(2,31) - 1 
        INT_MIN = -pow(2,31)    
        parsed = 0
        
        while i < len(s):
            cur = s[i]
            
            if not cur.isdigit():
                break
                
            else:
                parsed = parsed * 10 + int(cur)
            i += 1
        
        parsed *= sign
        
        if parsed > INT_MAX:
            return INT_MAX
        elif parsed <= INT_MIN:
            return INT_MIN
                
        else:
            return parsed