## Given an integer n, return an array ans of length n + 1 
# such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

from typing import List

##pop count approach: time complexity: O(NlogN) as each x would have logx bits nd round x/2 bits might be set
## space complexity : O(1) 
class Solution:
    def countBits(self, n: int) -> List[int]:
        
        def pop_count(x: int) -> int:
            count = 0
            while x != 0 :
                x &= x-1
                count += 1
            return count
        
        ans = [0]* (n+1)
        for x in range(n + 1):
            ans[x] = pop_count(x)
            
        return ans

    ##Approach 2: DP + Most Significant Bit
    ## In general, we have the following transition function for popcount P(x):P(x+b)=P(x)+1,b=2^m >x
    ##time complexity: O(n) as we perform constant number of operations for each integer x, in the range 0 to n
    ##space complexity: O(1)
    def countBitsI(self, n: int) -> List[int]:
        ans = [0] * (n+1)
        x = 0
        b = 1 #[0, b) is calculated
        while b <= n: 
            #generate [b, 2b) or [b, n) from [0, b)
            while x < b and x + b <= n:
                ans[x+b] = ans[x] + 1
                x += 1
            x=0 # reset x
            b <<=1 #b = 2b
            
        return ans
    
    ## Approach 3: DP + Least Significant Bit
    ## P(x) = P(x/2) + (x mod 2)
    ##time complexity: O(n) as we perform constant number of operations for each integer x, in the range 0 to n
    ##space complexity: O(1)
    def countBitsII(self, n: int) -> List[int]:
            
        ans = [0] * (n+1)
        for x in range(1, n+1):
            #x/2 is x>>1 and x%2 is x&1
            ans[x] = ans[x>>1] + (x&1)
            
        return ans

    ## DP + Last set bit approach
    ##time complexity: O(n) as we perform constant number of operations for each integer x, in the range 0 to n
    ##space complexity: O(1)
    
    def countBits(self, n: int) -> List[int]:
            
        ans = [0] * (n+1)
        for x in range(1, n+1):
            ans[x] = ans[x & (x-1)] + 1
            
        return ans


    