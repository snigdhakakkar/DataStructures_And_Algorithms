package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissingPositiveNumbers {
	
	public static void main(String[] args) {
		FirstKMissingPositiveNumbers a = new FirstKMissingPositiveNumbers();
		
		int[] arr = {-2, 11, 1, -3, 2, 8, 4};
		
		System.out.println(a.firstKMissingPositiveNumbers(arr, 5));
	}
	
	public List<Integer> firstKMissingPositiveNumbers(int[] arr, int k){
		if(arr.length == 0) {
			return new ArrayList<>();
		}
		
		int i = 0;
		while(i < arr.length) {
			if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]) {
				int otherIndex = arr[i] - 1;
				
				int x = arr[i];
				arr[i] = arr[otherIndex];
				arr[otherIndex] = x;
			} else {
				i++;
			}
		}
		
		List<Integer> missing_values = new ArrayList<Integer>();
		
		Set<Integer> otherNumbers = new HashSet<Integer>();
		
		for(i = 0; i < arr.length && missing_values.size() < k; i++) {
			if(arr[i] != i + 1) {
				missing_values.add(i + 1);
				otherNumbers.add(arr[i]);
			}
		}
		
		for(int j = i; missing_values.size() < k; j++) {
			
			if(!otherNumbers.contains(j + 1)) {
				missing_values.add(j + 1);
			}
		}
		
		return missing_values;
	}

}
