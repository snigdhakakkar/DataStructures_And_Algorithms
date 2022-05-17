package Top75;

import java.util.Arrays;

/*
 * Problem statement - Given an array of n integers nums and an integer target, 
 * find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition 
 * nums[i] + nums[j] + nums[k] < target.
 */
public class ThreeSumSmaller {
	
	//Approach 1 - bruteforce : Find every possible set of triplets (i,j,k) such that i<j<k and test for the condition
	
	/*Complexity analysis
	 * Time complexity: O(n^3). The total number of such triplets is nC3, which is n! /(n−3)!×3! = n×(n−1)×(n−2)/6. 
	 * Therefore, the time complexity of the brute force approach is O(n^3).
Space complexity: O(1).
*/

	//Approach 2: Binary search
	/*Intuition behind twoSum with similar condition - If we sort the array first, then we can apply binary search 
	 * to find the largest index j such that nums[i] + nums[j] < target for each i. Once we have found that largest index 
j, we know there must be j−i pairs that satisfy the above condition with i's value fixed.
	*/
	
	/*
	 * Complexity analysis

Time complexity: O(n^2logn). The binarySearch function takes O(logn) time, therefore the twoSumSmaller takes O(nlogn)
time. The threeSumSmaller wraps with another for-loop, and therefore is O(n^2logn) time.

Space complexity: O(1) because no additional data structures are used.
	 */
	
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		
		int sum = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			sum += twoSumSmaller(nums, i + 1, target - nums[i]);
		}
		
		return sum;
	}
	
	private int twoSumSmaller(int[] nums, int startIndex, int target) {
		
		int sum = 0;
		 for (int i = startIndex; i < nums.length - 1; i++) {
			 int j = binarySearch(nums, i, target - nums[i]);
			 sum += j - i;
		 }
		 
		 return sum;
	}
	
	private int binarySearch(int[] nums, int startIndex, int target) {
		int left = startIndex;
        int right = nums.length - 1;
        
        while (left < right) {
        	 int mid = (left + right + 1) / 2;
        	 
        	 if (nums[mid] < target) {
        		 left = mid;
        	 } else {
        		 right = mid - 1;
        	 }
        }
        
        return left;
	}
	
}