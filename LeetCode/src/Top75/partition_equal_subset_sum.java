package Top75;
/*
 * Problem statement  - Given a non-empty array nums containing only positive integers, 
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 */
public class partition_equal_subset_sum {
	
	 public boolean canPartition(int[] nums) {
	        //Approach 1 : Recursion, time complexity: O(2^n) and space complexity: O(n)
	        /* we can either choose an element or not
	        */
	        int sum = 0;
	        //calculate sum
	        for (int num : nums) {
	            sum += num;
	        }
	        if (sum % 2 != 0) { 
	        return false;}
	        
	        return recursion(nums, 0, sum/2);
	        //recursively checking whether there exists a subset with target sum or not
	    }
	    
	    private boolean recursion(int[] nums, int index, int sum) {
	        //base cases
	        if(sum == 0) { 
	        return true;
	        }
	        if (sum < 0 || index == nums.length) {
	            return false;
	        }
	        
	        return recursion(nums, index + 1, sum - nums[index]) || recursion(nums, index + 1, sum);
	        //either choose nums[index] or not
	    }
	    
	    

}
