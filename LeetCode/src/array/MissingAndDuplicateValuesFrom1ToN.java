package array;

import java.util.ArrayList;
import java.util.List;

public class MissingAndDuplicateValuesFrom1ToN {
	
	public static void main(String[] args) {
		MissingAndDuplicateValuesFrom1ToN a = new MissingAndDuplicateValuesFrom1ToN();
		int[] arr = {2,6, 4, 4, 3, 2};
		
		System.out.println(a.findDuplicateAndMissingValues(arr));
	}
	
	public List<List<Integer>> findDuplicateAndMissingValues(int[] arr){
		if(arr.length <= 1) {
			return new ArrayList<>();
		}
		
		int i = 0;
		while(i < arr.length) {
			if(arr[i] != arr[arr[i] - 1]) {
				int otherIndex = arr[i] - 1;
				
				int x = arr[i];
				arr[i] = arr[otherIndex];
				arr[otherIndex] = x;
			} else {
				i++;
			}
		}
		
		List<Integer> missingValues = new ArrayList<>();
		List<Integer> duplicateValues = new ArrayList<>();
		
		for(i = 0; i < arr.length; i++) {
			if(arr[i] != i + 1) {
				missingValues.add(i + 1);
				duplicateValues.add(arr[i]);
			}
		}
		
		List<List<Integer>> result = new ArrayList<>();
		
		result.add(missingValues);
		result.add(duplicateValues);
		
		return result;
		
	}

}
