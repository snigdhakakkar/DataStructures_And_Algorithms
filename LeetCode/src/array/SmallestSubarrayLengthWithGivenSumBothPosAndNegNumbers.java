package array;
import java.util.HashMap;
import java.util.Map;

public class SmallestSubarrayLengthWithGivenSumBothPosAndNegNumbers {
	
	public static void main(String[] args) {
		SmallestSubarrayLengthWithGivenSumBothPosAndNegNumbers a = new SmallestSubarrayLengthWithGivenSumBothPosAndNegNumbers();
		
		int[] arr1 = {4 ,2 , 5 , 2 ,1 , 8};
		int[] arr2 = {-12, -1, -13, 5, 4, 3, -1, 2};
		
		int smallest_length1 = a.findSmallestSubarrayLengthWithGivenSumBothPosAndNegNumbers(arr1, 9);
		int smallest_length2 = a.findSmallestSubarrayLengthWithGivenSumBothPosAndNegNumbers(arr2, -12);
		
		System.out.println(smallest_length1);
		System.out.println(smallest_length2);
	}
	
	public int findSmallestSubarrayLengthWithGivenSumBothPosAndNegNumbers(int[] arr, int sum) {
		if(arr.length == 0) {
			System.out.println("Array is empty.");
			return -1;
		}
		
		int start, end, totalSumTillNow, smallest_length;
		start = end = 0;
		totalSumTillNow = 0;
		smallest_length = Integer.MAX_VALUE;
		
		
		Map<Integer, Integer> map = new HashMap<>();
		
		while(end < arr.length) {
			totalSumTillNow = totalSumTillNow + arr[end];
			
			if(totalSumTillNow == sum) {
				System.out.println("Start index: " + 0 + ", End index: " + end);
				smallest_length = Math.min(end + 1, smallest_length);
			}
			
			int window_sum = totalSumTillNow - sum;
			
			if(map.containsKey(window_sum)) {
				start = map.get(window_sum);
				System.out.println("Start index: " + (start + 1) + ", End index: " + end);
				smallest_length = Math.min(end - start, smallest_length);
			}
			
			map.put(totalSumTillNow, end++);
		}
		
		return smallest_length != Integer.MAX_VALUE ? smallest_length : -1;
	}

}
