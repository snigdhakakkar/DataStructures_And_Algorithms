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
	    
	    /* In two pointer approach, we fix one number and use two pointers to enumerate pairs. Here, we fix two numbers, and use a binary search to find the third complement number. This is less efficient than the two pointers approach, however, it could be more intuitive to come up with.
	    
	      we may not find the exact complement number, so we check the difference between the complement and two numbers: the next higher and the previous lower.
	    */
	    public int threeSum1Closest(int[] nums, int target) {
	        
	        //Binary search Approach
	        
	        int diff = Integer.MAX_VALUE;
	        
	        int sz = nums.length;
	        
	        Arrays.sort(nums);
	        
	        for(int i = 0; i < sz && diff != 0; ++i) {
	            for(int j = i + 1; j < sz - 1; ++j) {
	                int complement = target - nums[i] - nums[j];
	                var idx = Arrays.binarySearch(nums, j + 1, sz - 1, complement);
	                int hi = idx >= 0 ? idx : ~idx, lo = hi - 1;
	                if (hi < sz && Math.abs(complement - nums[hi]) < Math.abs(diff)){
	                    diff = complement - nums[hi];
	                }
	                
	                if(lo > j && Math.abs(complement - nums[lo]) < Math.abs(diff)){
	                    diff = complement - nums[lo];
	                }
	            }
	        }
	        
	        return target - diff;
	        
	    }
	    
	    /*
	     * Time Complexity: O(n^2logn). Binary search takes O(logn), and we do it n times in the inner loop. 
	     * Since we are going through n elements in the outer loop, the overall complexity is O(n^2logn).
	     * 
	     * Space Complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm.
	     */
	    
	    
	
}
