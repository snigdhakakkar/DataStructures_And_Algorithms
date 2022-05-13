package Top75;

/*
 * Problem statement - There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is 

[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */

public class Search_In_Rotated_Sorted_Array {
	
	//problem is to implement a search in O(logN) time that gives an idea to use a binary search
	
	int [] nums;
    int target;
    
    
    public int find_rotate_index(int left, int right){
        if(nums[left] < nums[right]){
            return 0;
        }
        
        while (left <= right) {
            int pivot = (left + right)/2;
            if(nums[pivot] > nums[pivot + 1]){
                return pivot + 1;
            } else {
                if (nums[pivot] < nums[left]){
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        
        return 0;
    }
    
    public int search(int left, int right) {
        //applying binary search
        while (left <= right){
            int pivot = (left + right)/2;
            if(nums[pivot] == target){
                return pivot;
            } else {
                if (target < nums[pivot]){
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        
        return -1;
    }
    
    public int search(int[] nums, int target){
        this.nums = nums;
        this.target = target;
        
        int n = nums.length;
        
        if (n == 1){
            return this.nums[0] == target ? 0 : -1;
        }
        
        int rotate_index = find_rotate_index(0, n - 1);
        
        //if target is the smallest element
        if(nums[rotate_index] == target){
            return rotate_index;
        }
        
        //if array is not rotated, search in the entire array
        if (rotate_index == 0){
            return search(0, n-1);
        }
        
        if (target < nums[0]){
            //search in the right side
            return search(rotate_index, n - 1);
        } else {
            //search in the left side
            return search(0, rotate_index);
        }
        
    }

}
