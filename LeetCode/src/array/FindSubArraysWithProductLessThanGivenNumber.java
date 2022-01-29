package array;

import java.util.ArrayList;
import java.util.List;

public class FindSubArraysWithProductLessThanGivenNumber {
	
	public static void main(String[]  args) {
		
		FindSubArraysWithProductLessThanGivenNumber a = new FindSubArraysWithProductLessThanGivenNumber();
		int[] arr = {4, 2, 5, 3, 6};
		
		System.out.println(a.findSubArrayWithProductLessThanGivenNumber(arr, 45));
	}
	
	public static List<List<Integer>> findSubArrayWithProductLessThanGivenNumber(int[] arr, int number){
		int productOfNumbers = 1;
		int start = 0;
		List<List<Integer>> sol = new ArrayList<>();
		
		for(int i = 0; i < arr.length; i++) {
			productOfNumbers = productOfNumbers * arr[i];
			
			while(productOfNumbers >= number) {
				productOfNumbers = productOfNumbers / arr[start];
				start++;
			}
			
			List<Integer> list = new ArrayList<>();
			
			for(int j = i; j >= start; j--) {
				list.add(0, arr[j]);
				
				sol.add(new ArrayList<>(list));
			}
		}
		
		return sol;
	}

}
