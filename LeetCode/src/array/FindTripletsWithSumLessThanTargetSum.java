package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTripletsWithSumLessThanTargetSum {
	
	public static void main(String[]  args) {
		FindTripletsWithSumLessThanTargetSum a = new FindTripletsWithSumLessThanTargetSum();
		
		int[] arr = {1, 2, -3, 4, -2, -1};	
		System.out.println(a.findTripletsSumLessThanTargetSum(arr, 1));
		}
	
	public static List<List<Integer>> findTripletsSumLessThanTargetSum(int[] arr, int targetSum){
		
		Arrays.sort(arr);
		int tripletCount = 0;
		
		List<List<Integer>> filteredTriplets = new ArrayList();
		
		for(int i = 0; i < arr.length - 2; i++) {
			
			int start = i + 1;
			int end = arr.length - 1;
			
			while(start < end) {
				int t = arr[start] + arr[end] + arr[i];
				if (t < targetSum) {
					filteredTriplets.add(Arrays.asList(arr[start], arr[end], arr[i]));
					start++;
					tripletCount = tripletCount + end - start;
				} else {
					end--;
				} 
			}
		}
		System.out.println(tripletCount);
		return filteredTriplets;
	}

}
