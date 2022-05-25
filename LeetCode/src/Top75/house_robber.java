package Top75;

import java.util.Arrays;

/*
 * Problem statement: You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them 
 * is that adjacent houses have security systems connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.
 */

public class house_robber {
	
	//method1: recursion & memoization
	//time complexity: O(N) and space complexity: O(N)
	private int[] memo;
    
    public int rob(int[] nums) {
        
        this.memo = new int[100];
        
        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);
        
        return this.robFrom(0, nums);
        
    }
    
    private int robFrom(int i, int[] nums){
        // No more houses left to examine.
        if (i >= nums.length){
            return 0;
        }
        
        // Return cached value.
        if (this.memo[i] > -1) {
            return this.memo[i];
        }
        
        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);
        
        // Cache for future use.
        this.memo[i] = ans;
        return ans;
    }
    
    //BOTTOM-UP DYNAMIC PROGRAMMING APPROACH
   //time complexity: O(N) and space complexity: O(N)
    public int robI(int[] nums) {
        
        int N = nums.length;
        
        //special handling for empty array case
        if (N == 0) {
            return 0;
        }
        
        int[] maxRobbedAmount = new int[nums.length + 1];
        
        //base cases
        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N-1] = nums[N-1];
        
        //DP table calculations
        for (int i = N - 2; i >= 0; --i){
            // Same as the recursive solution.
            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
            }
        
        return maxRobbedAmount[0];
    }

}
