package Top75;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Problem statement - Given an integer array nums and an integer k, 
 * return true if there are two distinct indices i and j in the array 
 * such that nums[i] == nums[j] and abs(i - j) <= k
 */

public class ContainsDuplicateII {
	
	/*naive approach - linear search: This algorithm is the same as Approach #1 in Contains Duplicate solution, 
	 * except that it looks at previous k elements instead of all its previous elements.

	Another perspective of this algorithm is to keep a virtual sliding window of the previous 
	k elements. We scan for the duplicate in this window.*/
	
	/*
	 * Time complexity : O(nmin(k,n)). It costs O(min(k,n)) time for each linear search. Apparently we do at most 
	 * n comparisons in one search even if k can be larger than n; Space complexity : O(1).
	 */
	 public boolean containsNearbyDuplicate(int[] nums, int k) {
	        for (int i = 0; i < nums.length; ++i) {
	        for (int j = Math.max(i - k, 0); j < i; ++j) {
	            if (nums[i] == nums[j]) return true;
	        }
	    }
	    return false;
	    }
	 
	 /*second approach - use a BST to search
	  * in-built bST in Java can be obtained from TreeSet
	  */
	 
	 /*
	  * Time complexity : O(nlog(min(k,n))). We do n operations of search, delete and insert. 
	  * Each operation costs logarithmic time complexity in the sliding window which size is min(k,n). Note that even if 
	  * k can be greater than n, the window size can never exceed n.
	  * 
	  * Space complexity : O(min(n,k)). Space is the size of the sliding window which should not exceed n or k.
	  */
	 
	 public boolean containsNearbyDuplicate(int[] nums, int k) {
	        Set<Integer> set = new TreeSet<>();
	    for (int i = 0; i < nums.length; ++i) {
	        if (set.contains(nums[i])) return true;
	        set.add(nums[i]);
	        if (set.size() > k) {
	            set.remove(nums[i - k]);
	        }
	    }
	    return false;
	    }
	 
	 /*
	  * third approach - use hashmap
	  */
	 
	 public boolean containsNearbyDuplicate(int[] nums, int k) {
		    Set<Integer> set = new HashSet<>();
		    for (int i = 0; i < nums.length; ++i) {
		        if (set.contains(nums[i])) return true;
		        set.add(nums[i]);
		        if (set.size() > k) {
		            set.remove(nums[i - k]);
		        }
		    }
		    return false;
		}
	 

}
