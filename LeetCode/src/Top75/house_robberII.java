package Top75;

/*
 * Problem statement: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
 * All houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, adjacent houses have a security system connected, 
 * and it will automatically contact the police if two adjacent houses were broken 
 * into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.
 */

public class house_robberII {
	//DP approach: time complexity: O(N), Space complexity: O(1)
	public int rob(int[] nums) {
        
        if (nums.length == 0)
            return 0;
        
        if (nums.length == 1)
            return nums[0];
        
        int max1 = rob_simple(nums, 0, nums.length - 2);
        int max2 = rob_simple(nums, 1, nums.length - 1);
        
        return Math.max(max1, max2);
        
    }
    
    public int rob_simple(int[] nums, int start, int end){
        int t1 = 0;
        int t2 = 0;
        
         for (int i = start; i <= end; i++) {
             int temp = t1;
             int current = nums[i];
             t1 = Math.max(current + t2, t1);
             t2 = temp;
         }
        
        return t1;
    }

}
