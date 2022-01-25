package array;

public class SearchValuesInAnArray {
	
	public static void main(String[] args) {
		
		SearchValuesInAnArray s = new SearchValuesInAnArray();
		
		int arr[] = {5, 90, 3, 65, 6};
		int index = s.searchValueInUnsortedArray(arr, 3);
		System.out.println(index);
		
		int sortedArray[] = {3, 5, 7, 89, 100};
		int index1 = s.binarySearchSortedArray(sortedArray, 0, sortedArray.length - 1, 89);
		System.out.println(index1);
	}
	
	public int binarySearchSortedArray(int[] arr, int start, int end, int value) {
		
		while(start <= end) {
			int mid = (start+end)/2;
			if(arr[mid] == value) {
				return mid;
			} else if (value > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return -1;
	}
	
	public int searchValueInUnsortedArray(int[] arr, int val) {
		if(arr.length == 0) {
			return -1;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == val) {
				return i;
			}
		}
		
		return -1;
	}

}
