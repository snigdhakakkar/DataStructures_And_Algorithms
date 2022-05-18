package Top75;

import java.util.Arrays;

/*
 * Problem statement -  Given an array nums containing n distinct numbers 
 * in the range [0, n], return the only number in the range that is missing 
 * from the array.
 */

/*
 * Follow up: Could you implement a solution using 
 * only O(1) extra space complexity and O(n) runtime complexity?
 */
public class missing_number {
	
	public int missingNumber(int[] nums) {
        
        /*time complexity: O(nlogn); space complexity: O(1) or O(n) 
        based on if we are sorting arrays inplace or not*/
        Arrays.sort(nums);
        
        //handling the edge cases
        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }
        
        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++){
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        
        // Array was not missing any numbers
        return -1;
        
    }
	
	

}
