package array;

public class SubArrayWithGivenSum {
	
	public static void main(String[] args) {
		
		SubArrayWithGivenSum a = new SubArrayWithGivenSum();
		
		int[] arr = {4 ,2 , 5 , 2 ,1 , 8};
		
		a.findSubArrayPositiveNumbers(arr, 9);
	}
	
	public void findSubArrayPositiveNumbers(int[] arr, int sum) {
		if(arr.length == 0) {
			System.out.println("Array is empty.");
		}
		
		int start, end, window_sum;
		start = end = 0;
		window_sum = 0;
		
		while(end < arr.length) {
			window_sum  = window_sum + arr[end];
			
			if(window_sum  == sum) {
				System.out.println("Start index: " + start + ", End index: " + end);
				return;
			}
			
			while(window_sum > sum && start <= end) {
				window_sum = window_sum - arr[start++];
				
				if(window_sum  == sum) {
					System.out.println("Start index: " + start + ", End index: " + end);
					return;
				}
				
			}
			
			end++;
		}
		
		System.out.println("There is no such subarray.");
	}

}
