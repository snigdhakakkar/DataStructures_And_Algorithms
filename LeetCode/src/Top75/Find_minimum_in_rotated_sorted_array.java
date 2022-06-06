package Top75;

/*
 * Problem statement - Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
 */



public class Find_minimum_in_rotated_sorted_array {
	
	public int findMin(int[] nums) {
        //if the list just has one element, then return that particular element
        if(nums.length == 1){
            return nums[0];
        }
               
        //initializing left and right pointers for implementing modified binary search
        int left = 0, right = nums.length - 1;
        
        //if the last element is greater than the first element, then the array is in the sorted order
        //there is no rotation
        //hence the smallest element is the first element of the array
        if(nums[right] > nums[left]){
            return nums[0];
        }
        
        //binary search modified
        while(right >= left){
            //find the mid element
            int mid = left + (right - left) /2;
            
            //if the mid element is greater than its next element, then mid + 1 element is the smallest
            //this point would be the inflection point i.e. the point of change from higher to lower value
            
            if(nums[mid] > nums[mid + 1]){
                return nums[mid+1];
            }
            
            //if the mid element's value is lesser than the previous element, then the mid element is the smallest
            if(nums[mid - 1] > nums[mid]){
                return nums[mid];
            }
            
            //if the mid element's value is greater than the zeroth element, this means the least value is still somewhere to the right
            if(nums[mid] > nums[0]){
                left = mid+1;
            } else {
                //if nums[0] is greater than the mid element, then the inflection point and the smallest value is somewhere to the left
                right = mid - 1;
            }
        }
        
        return -1;
    }
}

