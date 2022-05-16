package Top75;

import java.util.Arrays;

/*
 * Problem Statement - Given an integer array nums of length n and an integer target, find three integers in nums 
 * such that the sum is closest to target. Return the sum of the three integers.
You may assume that each input would have exactly one solution.


 */

public class ThreeSumClosest {
	
	/* We cannot use a hashSet approach here as we do not have a specific value to look for.
	    */
	
	/*
	 * Time Complexity: O(n^2). We have outer and inner loops, each going through n elements.

Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n^2). This is asymptotically equivalent to O(n^2).

Space Complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm.
	 */
	    public int threeSumClosest(int[] nums, int target) {
	        
	        //Two pointer Approach
	        
	        int diff = Integer.MAX_VALUE;
	        
	        int sz = nums.length;
	        
	        Arrays.sort(nums);
	        
	        for(int i = 0; i < sz && diff != 0; ++i) {
	            int lo = i + 1;
	            int hi = sz - 1;
	            
	            while(lo < hi){
	                int sum = nums[i] + nums[lo] + nums[hi];
	                if(Math.abs(target - sum) < Math.abs(diff)) {
	                    diff = target - sum;
	                }
	                
	                if(sum < target){
	                    ++lo;
	                } else {
	                    --hi;
	                }
	            }
	        }
	        
	        return target - diff;
	        
	    }
	    
	    
	
}
