package Top75;

public class Search_In_Rotated_SubArray_Approach2 {
	
	//time complexity: O(logN), Space complexity: O(1)
    //One-pass binary search
    
    public int search(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        
        while (start <= end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target){
                return mid;
                //if the middle number is in the unrotated segment and target value is less than the mid value
            } else if (nums[mid] >= nums[start]){
                if (target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
           
        return -1;
    }

}
