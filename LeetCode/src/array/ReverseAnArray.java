package array;

import java.util.Arrays;
import java.util.Collections;

public class ReverseAnArray {
	
	public static void main(String[] args) {
		ReverseAnArray a = new ReverseAnArray();
		
		int[] arr = {1, 2, 3, 4, 5};
		
		int[] result = a.reverseAnArray1(arr, arr.length);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");}
			
		System.out.println();
		a.reverseAnArray2(arr, arr.length);
		
		for(int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		
		System.out.println();
		//Method3 - use built-in reverse
		Integer[] arr1 = {1,2,3,4,5};
		
		Collections.reverse(Arrays.asList(arr1));
		
		for(int j = 0; j < arr1.length; j++) {
			System.out.print(arr1[j] + " ");
		}
		
	}
	
	/* Method 1 to reverse: Create a new array of size of the original array.
	 * Take a start pointer for start of original array and an end pointer for end of new array.
	 * Copy each element from the start of original array to the end of new array.
	 * Increment start pointer and decrement end pointer.
	 * Time complexity: O(N)
	 * Space complexity: O(N) 
	 */
	public int[] reverseAnArray1(int[] arr, int length) {
		if(arr.length <= 1) {
			return arr;
		}
		
		int[] new_arr = new int[length];
		
		int j = length;
		
		for(int i = 0; i < length; i++) {
			new_arr[j - i - 1] = arr[i];
		}
		
	return new_arr;
	}
	
	/*Use the original array and swap element from the beginning with the element in the end in each iteration until
	 * you reach n/2 element.
	 * Time complexity: O(N); Space complexity: O(1)
	 */
	public void reverseAnArray2(int[] arr, int l) {
		if(arr.length <= 1) {
			return;
		}
		
		int tmp = 0;
		
		for (int i = 0; i < l/2; i++) {
			tmp = arr[i];
			arr[i] = arr[l - i - 1];
			arr[l - i - 1] = tmp;
		}
	}
	

}
