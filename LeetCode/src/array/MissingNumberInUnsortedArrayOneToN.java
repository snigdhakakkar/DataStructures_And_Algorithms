package array;

public class MissingNumberInUnsortedArrayOneToN {

	public static void main(String[] args) {
		MissingNumberInUnsortedArrayOneToN m = new MissingNumberInUnsortedArrayOneToN();
		
		int arr[] = {2, 6, 4, 1, 3, 7, 8};
		System.out.println(m.missingNumberInUnsortedArray(arr, arr.length + 1));
	}
	
	public int missingNumberInUnsortedArray(int[] arr, int n) {
		int sum = (n * (n + 1))/2;
		
		for(int i = 0; i < arr.length; i++) {
			sum = sum - arr[i];
		}
		
		return sum;
	}
}
