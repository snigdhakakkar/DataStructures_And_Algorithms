package Top75;

import java.util.HashMap;
import java.util.Map;
/*
 * Problem statement: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */
public class TwoSum {
	    public int[] twoSum(int[] nums, int target) {
	        //Bruteforce appraoch: check for sum of current value with each value in the array and compare with the target value; time complexity: O(n^2) and space complexity: O(1);
	        //Improved approach: if there is certain x that when added to current value yields the target value, then we have an answer. We can use a map to store the values; time complexity: O(N) and space complexity O(N)
	        
	        Map<Integer, Integer> map = new HashMap<>();
	           
	        for (int i = 0; i < nums.length; i++){
	            int cur = nums[i];
	            //cur + x = target
	            //x = target - cur
	            int x = target - cur;
	            
	            if (map.containsKey(x)){
	                return new int[]
	                { map.get(x), i
	                } ;
	            }
	                map.put(cur, i);
	            }
	            return null;
	    }

}
