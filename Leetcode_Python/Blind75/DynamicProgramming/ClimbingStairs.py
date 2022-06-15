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

