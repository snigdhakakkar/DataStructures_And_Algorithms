package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllQuadruplesForGivenTargetSum {
	
	public static void main(String[]  args) {
		FindAllQuadruplesForGivenTargetSum a = new FindAllQuadruplesForGivenTargetSum();
		
		int[] arr = {1, 2, -3, 4, -2, -1, 3};	
		
		System.out.println(a.findQuadruples(arr, 3));
	}
	
	public static List<List<Integer>> findQuadruples(int[] arr, int targetSum){
		Arrays.sort(arr);
		
		List<List<Integer>> allQuadruples = new ArrayList();
		
		for(int i = 0; i < arr.length - 3; i++) {
			for(int j = i + 1; j < arr.length - 2; j++) {
				int sum = targetSum - arr[i] - arr[j];
				int start = i + 2;
				int end = arr.length - 1;
				
				while(start < end) {
					int t = arr[start] + arr[end];
					if(t == sum) {
						allQuadruples.add(Arrays.asList(arr[start], arr[end], arr[i], arr[j]));
						start++;
						end--;
					} else if (t < sum){
						start++;
					} else {
						end--;
					}
				}
			}
		}
		
		return allQuadruples;
	}

}
