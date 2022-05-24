package Top75;

/*
 * Problem statement - Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum. A subarray is a contiguous part of an array.
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another 
 * solution using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubarray {
	
	public int maxSubArray(int[] nums) {
        
	       //BruteForce approach - Calculate the sum of all subarrays, and keep track of the best one. To actually generate all subarrays would take O(N^3) time, but with a little optimization, we can achieve brute force in  O(N^2) time. The trick is to recognize that all of the subarrays starting at a particular value will share a common prefix.
	        
	        int maxSubarray = Integer.MIN_VALUE;
	        for (int i = 0; i < nums.length; i++) {
	            int currentSubarray = 0;
	            for (int j = i; j < nums.length; j++) {
	                currentSubarray += nums[j];
	                maxSubarray = Math.max(maxSubarray, currentSubarray);
	            }   
	        }
	        
	        return maxSubarray;
	        
	        //Time complexity: O(N^2), space complexity: O(1)
	    }
	
	public int maxSubArray1(int[] nums) {
        /*Dynamic Programming - Kadane's approach
        */
       // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        
        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        
        return maxSubarray;
        
        //time complexity: O(N); space complexity: O(1)
    }
	
	private int[] numsArray;
    //Divide and conquer approach - time complexity: O(NlogN), space complexity: O(logN)
    
    public int maxSubArray2(int[] nums) {
        numsArray = nums;
        
        // Our helper function is designed to solve this problem for
        // any array - so just call it using the entire input!
        return findBestSubarray(0, numsArray.length - 1);
    }
    
    private int findBestSubarray(int left, int right) {
        // Base case - empty array.
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        
        int mid = Math.floorDiv(left + right, 2);
        int curr = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;
        
        // Iterate from the middle to the beginning.
        for (int i = mid - 1; i >= left; i--) {
            curr += numsArray[i];
            bestLeftSum = Math.max(bestLeftSum, curr);
        }
        
        // Reset curr and iterate from the middle to the end.
        curr = 0;
        for (int i = mid + 1; i <= right; i++) {
            curr += numsArray[i];
            bestRightSum = Math.max(bestRightSum, curr);
        }
        
        // The bestCombinedSum uses the middle element and the best
        // possible sum from each half.
        int bestCombinedSum = numsArray[mid] + bestLeftSum + bestRightSum;
        
        // Find the best subarray possible from both halves.
        int leftHalf = findBestSubarray(left, mid - 1);
        int rightHalf = findBestSubarray(mid + 1, right);
        
        // The largest of the 3 is the answer for any given input array.
        return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
    }   
    
	
	
	
	

}
