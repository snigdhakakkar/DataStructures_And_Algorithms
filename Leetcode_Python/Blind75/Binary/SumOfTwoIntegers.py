##Given two integers a and b, return the sum of the two integers without using the operators + and -.
##time complexity: O(1) because each integer contains 32 bits, space complexity: O(1)

def getSum(self, a: int, b: int) -> int:
        
        x,y = abs(a), abs(b)
        # ensure that abs(a) >= abs(b)
        if x < y:
            return self.getSum(b,a)
        
        # abs(a) >= abs(b) --> 
        # a determines the sign
        if a > 0:
            sign = 1
        else:
            sign = -1
            
        # sum of two positive integers x + y
        # where x > y
        if a * b >= 0:
            while y:
                answer = x ^ y
                carry = (x & y) << 1
                x, y = answer, carry
        
        else:
            while y:
                answer = x ^ y
                borrow = ((~x)&y) << 1
                x, y = answer, borrow
                
        return x * sign