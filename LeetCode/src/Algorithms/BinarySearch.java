package Algorithms;

public class BinarySearch {
	
	static int search(int[] nums, int target) {
        
        int index_trgt = -1; //storing the index of the target in a variable
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index_trgt = i;
            }
        }
        
        return index_trgt;
	}
	
	public static void main(String[] args) {
		int nums1[] = {-1,0,3,5,9,12};
		int target = 9;
		int index = search(nums1, target);
		System.out.println(index);
	}
}
