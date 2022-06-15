## Reverse bits of a given 32 bits unsigned integer.
# Note:
# Note that in some languages, such as Java, there is no unsigned integer type. 
# In this case, both input and output will be given as a signed integer type. 
# They should not affect your implementation, as the integer's internal binary representation is the same, 
# whether it is signed or unsigned.
# In Java, the compiler represents the signed integers using 2's complement notation. 
# Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents 
# the signed integer -1073741825.

#Follow up: If this function is called many times, how would you optimize it?

##Approach 1: bit by bit reverse
## time complexity: O(1), space complexity: O(1)
class Solution:
    def reverseBits(self, n: int) -> int:
        ret, power = 0, 31
        while n:
            ret += (n & 1) << power
            n = n >> 1
            power -= 1
            
        return ret

## Approach 2: divide and conquer approach
## time complexity: O(1) and space complexity: O(1)
    def reverseBits(self, n: int) -> int:
        n = (n >> 16) | (n << 16)
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8)
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4)
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2)
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1)
        return n

