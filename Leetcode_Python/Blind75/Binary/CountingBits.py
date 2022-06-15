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

    