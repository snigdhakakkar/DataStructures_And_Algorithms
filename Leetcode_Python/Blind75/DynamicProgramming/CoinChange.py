## You are given an integer array coins representing coins of different denominations and 
# an integer amount representing a total amount of money.
# Return the fewest number of coins that you need to make up that amount. 
# If that amount of money cannot be made up by any combination of the coins, return -1.
# You may assume that you have an infinite number of each kind of coin.

##DP approach
from typing import List


def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')]*(amount+1)
        
        dp[0] = 0
        
        for coin in coins:
            for x in range(coin, amount+1):
                dp[x] = min(dp[x], dp[x - coin] + 1)
        
        return dp[amount] if dp[amount] != float('inf') else -1 

## Memoization approach
def coinChange(self, coins: List[int], amount: int) -> int:
        memo = [[0 for j in range(amount+1)] for i in range(len(coins) + 1)]
        for j in range(1, len(memo[0])):
                memo[0][j] = float('inf')
        for i in range(1, len(memo)):
            for j in range(1, len(memo[0])):
                if coins[i - 1] <= j:
                    memo[i][j] = min(memo[i-1][j], memo[i][j-coins[i-1]]+1)
                else:
                    memo[i][j] = memo[i-1][j]
        return memo[-1][-1] if memo[-1][-1] != float('inf') else -1
                