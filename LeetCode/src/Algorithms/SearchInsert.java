package Algorithms;

public class SearchInsert {
	
	static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = 0;
        
        while (low <= high) {
            
            mid = low + (high - low) / 2;
            
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            
        }
        
        if (nums[mid] < target) {
            mid++;
        }
        
        return mid;
        
    }
	
	 //Driver method
    public static void main(String[] args){
        int nums1[] = {1,3,5,6,7,8};
        System.out.println(searchInsert(nums1, 5));
        }
}
