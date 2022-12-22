##TIME COMPLEXITY: O(N)
##Space complexity: O(1)

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(1, len(prices)):
            ##check if next day price is greater than the previous day price
            if prices[i] >= prices[i - 1]:
                profit += (prices[i] - prices[i - 1])
                
        return profit