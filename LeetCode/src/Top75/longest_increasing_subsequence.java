package Top75;

import java.util.Arrays;

/*
 * Problem statement - Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the 
order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */

public class longest_increasing_subsequence {
	
	/* Realizing a Dynamic Programming Problem: This problem has two important attributes that let us know 
	 * it should be solved by dynamic programming. First, the question is asking for the maximum or minimum of 
	 * something. Second, we have to make decisions that may depend on previously made decisions, which is very 
	 * typical of a problem involving subsequences.
    */
	
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                 if (nums[i] > nums[j]){
                      dp[i] = Math.max(dp[i], dp[j] + 1);
                 }
            }
        }
        
        int longest = 0;
         for (int c: dp){
             longest = Math.max(longest, c);
         }
        
        return longest;
        
        //time complexity: O(N^2); Space complexity: O(N)
    }

}
