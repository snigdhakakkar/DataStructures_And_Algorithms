package Top75;

/*
 * Problem statement - You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.
 */

public class Best_Time_To_Buy_Sell_Stock_II {
	
	//approach 1
	 public int maxProfit1(int[] prices) {
	        
	        //time complexity: O(N); Space complexity: O(1);
	        //Keep track of local max, local min, and next valley
	        
	        int total = 0;
	        int valley = Integer.MAX_VALUE;
	        int peak = valley;
	        
	        for(int i = 0; i < prices.length; i++){
	            if (prices[i] < peak){
	                total += peak - valley;
	                
	                valley = prices[i];
	                peak = valley;
	            } else {
	                peak = prices[i];
	            }
	        }
	        
	        total += peak - valley;
	        
	        return total;
	        
	    }
	 
	 //approach 2 - simpler approach
	 
	 public int maxProfit(int[] prices) {
	        
	        //approach 2: adding only the positive differences
	        //time complexity: O(n); space complexity: O(1);
	        
	        int total = 0;
	        
	        for(int i = 1; i < prices.length; i++){
	            if(prices[i] > prices[i - 1]){
	                total += prices[i] - prices[i - 1];
	            }
	        }
	        
	        return total;
	        
	        
	    }

}
