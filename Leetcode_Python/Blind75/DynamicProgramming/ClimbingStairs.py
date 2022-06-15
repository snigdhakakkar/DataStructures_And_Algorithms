## You are climbing a staircase. It takes n steps to reach the top.
# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

##Fibonacci approach: recursively
##time complexity: O(2^n) ; space complexity: O(1)

class Solution:
    def climbStairs(self, n: int) -> int:
        def fib(n: int) -> int:
            if n <= 1:
                return n
            return fib(n-1) + fib(n-2)
        
        return fib(n + 1)
## memoization approach
    def climbStairs(self, n: int) -> int:
        
        dp = [-1 for i in range(n + 1)]
        def fib(n, dp):
            
            if (n <= 1):
                return 1
            
            if (dp[n] != -1):
                return dp[n]
            
            dp[n] = fib(n - 1, dp) + fib(n - 2, dp)
            return dp[n]
        fib(n, dp)
        
        return dp[n]

## Another approach
    def climbStairs(self, n: int) -> int:
        
        if n == 1 or n == 2:
            return n
        
        prevPrev = 1
        prev = 2
        current = 0
        
        for i in range(3, n+1):
            current = prev + prevPrev
            prevPrev = prev
            prev = current
            
        return current