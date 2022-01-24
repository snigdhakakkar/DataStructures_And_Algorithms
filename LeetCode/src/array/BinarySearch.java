package array;

public class BinarySearch {
	
	public static void main(String[] args) {
		//needs a sorted array only
		int a[] = {12, 34, 45, 65, 83};
		BinarySearch b = new BinarySearch();
		int i = b.searchIndex(a, 83, 0, a.length -1);
		if(i == -1) {
			System.out.println("value does not exist in the array.");
		} else {
			System.out.println(i);
		}
	}
	
	public int searchIndex(int[] a, int val, int start, int end) {
		if(a.length == 0 || start > end) {
			return -1;
		}
		
		int mid = (start + end)/2;
		
		if(val == a[mid]) {
			return mid;
		}
		
		if(val < a[mid]) {
			return searchIndex(a, val, start, mid -1);
		} else {
			return searchIndex(a, val, mid +1, end);
		}
	}

}
