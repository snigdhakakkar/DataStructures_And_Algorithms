##Sliding window approach: time complexity: O(N), space complexity: O(1)

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l, r = 0, 1 # left = buy, right = sell
        max_Profit = 0
        
        while r < len(prices):
            if prices[l] < prices[r]:
                profit = prices[r] - prices[l]
                max_Profit = max(max_Profit, profit)
            else:
                l = r
            r += 1
            
        return max_Profit