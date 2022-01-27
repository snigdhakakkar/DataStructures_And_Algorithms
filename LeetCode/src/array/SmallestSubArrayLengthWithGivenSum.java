package array;

public class SmallestSubArrayLengthWithGivenSum {
	
	public static void main(String[] args) {
		
		SmallestSubArrayLengthWithGivenSum a = new SmallestSubArrayLengthWithGivenSum();
		
		int[] arr1 = {3 ,2 ,5 ,5 ,3 , 2, 10};
		int smallest_length = a.findSmallestSubArrayLengthWithGivenSumPositiveNumbers(arr1, 10);
		System.out.println(smallest_length);
	}
	
	public int findSmallestSubArrayLengthWithGivenSumPositiveNumbers(int[] arr, int sum) {
		if(arr.length == 0) {
			System.out.println("Array is empty.");
			return -1;
		}
		
		int start, end, window_Sum, smallest_length;
		start = end = 0;
		window_Sum = 0;
		smallest_length = Integer.MAX_VALUE;
		
		while(end < arr.length) {
			window_Sum = window_Sum + arr[end];
			
			if(window_Sum == sum) {
				System.out.println("Start index: " + start + ", End index: " + end);
				smallest_length = Math.min(end - start + 1, smallest_length);
			}
			
			while(window_Sum > sum && start <= end) {
				window_Sum = window_Sum - arr[start++];
				
				if(window_Sum == sum) {
					System.out.println("Start index: " + start + ", End index: " + end);
					smallest_length = Math.min(end - start + 1, smallest_length);
				}
			}
			
			end++;
		}
		
		return smallest_length != Integer.MAX_VALUE ? smallest_length : -1;
	}
	
	

}
