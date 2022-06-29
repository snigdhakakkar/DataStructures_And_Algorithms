##You are given an array prices where prices[i] is the price of a given stock on the ith day.You want to maximize your profit by choosing a 
# single day to buy one stock and choosing a different day in the future to sell that stock.
# Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        
        for i in range(len(prices) - 1):
            for j in range(i+1, len(prices)):
                profit = prices[j] - prices[i]
                
                if profit > max_profit:
                    max_profit = profit
                    
        return max_profit
##time complexity: O(n^2); space complexity: O(1)

def maxProfitI(self, prices: List[int]) -> int:
        min_price = float('inf')
        max_profit = 0
        
        for i in range(len(prices)):
            if prices[i] < min_price:
                min_price = prices[i]
            elif prices[i] - min_price > max_profit:
                max_profit = prices[i] - min_price
        
        
        return max_profit
##time complexity: O(n); space complexity: O(1)