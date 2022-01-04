package Algorithms;

public class BinarySearch {
	
	static int binSearch(int[] nums, int target) {
        
        if(nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, target, 0, nums.length -1) ;
        
    }
    
    static int binarySearch(int[] nums, int target, int low, int high) {
        if(high >= low) {
            int mid = (low + high)/2 ;
        
            if(target == nums[mid]) {
            return mid;
            } else if (target < nums[mid]){
                return binarySearch(nums, target, low, mid-1);
            } else {
                return binarySearch(nums, target, mid+1, high);
            }
        }
    return -1;
    }
    
    public static void main(String[] args) {
		int nums1[] = {-1,0,3,5,9,12};
		int target = 9;
		int index = binSearch(nums1, target);
		System.out.println(index);
	}
    

}
