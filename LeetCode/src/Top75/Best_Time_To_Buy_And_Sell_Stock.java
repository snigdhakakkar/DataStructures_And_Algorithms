package Top75;

/* Problem statement - You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 * 
 */
public class Best_Time_To_Buy_And_Sell_Stock {
	
	    public int maxProfit(int[] prices) {
	        
	        /*Brute-force appraoch: calculate the difference on a certain day and store the largest different
	        in a variable largest; time complexity- O(N^2); Space compexity - O(1);
	        */
	        
	        int largestDifference = 0;
	        
	        for (int buyDay = 0; buyDay < prices.length; buyDay++){
	            for (int sellDay = buyDay + 1; sellDay < prices.length; sellDay++){
	                int currentDifference = prices[sellDay] - prices[buyDay];
	                
	                if(currentDifference > largestDifference) {
	                    largestDifference = currentDifference;
	                }
	            }
	        }
	        
	        return largestDifference;
	        
	    }
	    
	    public int maxProfit1(int[] prices) {
	        
	        /*to get the largest profit, we need to get the lowest buy point and the larger sell point
	        Time complexity = O(N); space complexity: O(1);
	        */
	        
	        //keep track of the best buy day so far
	        //keep track of the largest difference so far
	        
	        int largestDifference = 0;
	        int minBuyPriceSoFar = Integer.MAX_VALUE;
	        
	        for(int i = 0; i < prices.length; i++){
	            if(prices[i] < minBuyPriceSoFar) {
	                minBuyPriceSoFar = prices[i];
	            } else {
	                largestDifference = Math.max(largestDifference, prices[i] - minBuyPriceSoFar);
	            }
	        }
	        
	        return largestDifference;
	    } 

}
