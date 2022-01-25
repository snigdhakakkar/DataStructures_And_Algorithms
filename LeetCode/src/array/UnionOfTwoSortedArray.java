package array;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArray {
	
	public static void main(String[] args) {
		
		UnionOfTwoSortedArray a = new UnionOfTwoSortedArray();
		
		int[] arr1 = {2,2,2,3,3,4,7,8};
		int[] arr2 = {1,2,4,4,6,6,7,8,10};
		
		List<Integer> UnionArray = new ArrayList<>();
		a.unionOfTwoSortedArray(arr1, arr2, UnionArray);
		System.out.println(UnionArray);
	}
	
	public void unionOfTwoSortedArray(int[] arr1, int[] arr2, List<Integer> finalList) {
		int i = 0;
		int j = 0;
		
		while(i < arr1.length && j < arr2.length) {
			while((i < arr1.length -1) && (arr1[i] == arr1[i+1])){
				i++;
			}
			
			while((j < arr2.length -1) && (arr2[j] == arr2[j+1])) {
				j++;
			}
			
			if(arr1[i] < arr2[j]) {
				finalList.add(arr1[i++]);
			} else if (arr1[i] > arr2[j]) {
				finalList.add(arr2[j++]);
			} else {
				finalList.add(arr1[i]);
				i++;
				j++;
			}
		}
	}
	
	

}
