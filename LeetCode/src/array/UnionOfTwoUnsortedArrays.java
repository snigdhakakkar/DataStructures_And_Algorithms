package array;

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoUnsortedArrays {
	
	public static void main(String[] args) {
		
		UnionOfTwoUnsortedArrays a = new UnionOfTwoUnsortedArrays();
		
		int[] arr1 = {4,2,3,5,4,2,3};
		int[] arr2 = {9,1,7,2,4,2,1,2};
		
		Set<Integer> finalUnion = new HashSet<>();
		
		a.unionOfTwoUnsortedArrays(arr1, arr2, finalUnion);
		System.out.println(finalUnion);
	}
	
	public void unionOfTwoUnsortedArrays(int[] arr1, int[] arr2, Set<Integer> finalUnion) {
		int i = 0;
		int j = 0;
		
		while(i < arr1.length) {
			finalUnion.add(arr1[i++]);
		}
		
		while(j < arr2.length) {
			finalUnion.add(arr2[j++]);
		}
	}
}
