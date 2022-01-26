package array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSumBothPositiveAndNegativeNo {
	
	public void findSubArray(int[] arr, int sum) {
		if(arr.length == 0) {
			System.out.println("Array is empty.");
		}
		
		int end, totalSumTillNow;
		end = 0;
		totalSumTillNow = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		while(end < arr.length) {
			totalSumTillNow = totalSumTillNow + arr[end];
			
			if(totalSumTillNow == sum) {
				System.out.println("Start index: " + 0 + ", End index: " + end);
				return;
			}
			
			int window_sum = totalSumTillNow - sum;
			
			if(map.containsKey(window_sum)) {
				int start = map.get(window_sum);
				System.out.println("Start index: " + (start + 1) + ", End index: " + end);
				return;
			}
			
			map.put(totalSumTillNow, end++);
		}
		
	}
	
	public static void main(String[] args) {
		
		SubArrayWithGivenSumBothPositiveAndNegativeNo a = new SubArrayWithGivenSumBothPositiveAndNegativeNo();
		
		int[] arr1 = {4 ,2 , 5 , 2 ,1 , 8};
		int[] arr2 = {-12, -1, -13, 5, 4, 3, -1, 2};
		
		a.findSubArray(arr1, 9);
		a.findSubArray(arr2, -21);
	}

}
