package array;

public class RemoveDuplicatesFromSortedArray {
	
	public static void main(String[]  args) {
		
		RemoveDuplicatesFromSortedArray a = new RemoveDuplicatesFromSortedArray();
		int[] arr = {1, 4, 4, 4, 5, 6, 7, 7, 9};
		
		System.out.println(a.getUniqueNumberLengthAfterremoingeDuplicates(arr));
	}
	
	public int getUniqueNumberLengthAfterremoingeDuplicates(int[] arr) {
		if(arr.length <=1) {
			return arr.length;
		}
		
		int start = 1;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[i-1]) {
				arr[start++] = arr[i];
			}
		}
		
		return start;
	}

}
