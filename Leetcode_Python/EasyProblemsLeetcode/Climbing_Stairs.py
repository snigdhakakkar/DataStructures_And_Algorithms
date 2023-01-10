## Approach 1: Bruteforce : Recursion (DFS): time complexity - O(2^n)

## Approach 2: Memoization: O(n) - caching the results

## Approach 3: Bottom Up DP : O(N)

## n-1 values are computed after assuming 2 base variable cases in bottom up DP

class Solution:
    def climbStairs(self, n: int) -> int:
        one, two = 1, 1
        for i in range(n - 1):
            temp = one
            one = one + two
            two = temp
            
        return one


        