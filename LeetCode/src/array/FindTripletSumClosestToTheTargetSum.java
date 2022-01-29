package array;

import java.util.Arrays;

public class FindTripletSumClosestToTheTargetSum {
	
	public static void main(String[]  args) {
		FindTripletSumClosestToTheTargetSum a = new FindTripletSumClosestToTheTargetSum();
		
		int[] arr = {1, 2, -3, 4, -2, -1};	
		System.out.println(a.findClosestSumOfTriplets(arr, 1));
		}
	
	public static int findClosestSumOfTriplets(int[] arr, int sum){
		Arrays.sort(arr);
		
		int minDiff = Integer.MAX_VALUE;
		int closestSum = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length-2; i++) {
			
			int start = i + 1;
			int end = arr.length - 1;
			
			while (start < end) {
				int tripletSum = arr[i] + arr[start] + arr[end];
				
				if(Math.abs(sum - tripletSum) <= minDiff && tripletSum < closestSum) {
					minDiff = Math.abs(sum - tripletSum);
					closestSum = tripletSum;
				}
				
				if(tripletSum == sum) {
					return tripletSum;
				} else if(tripletSum < sum) {
					start++;
				} else {
					end--;
				}
			}
		}
		return closestSum;
	}
	
	

}
