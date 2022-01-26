package array;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoUnsortedArrays {
	
	public static void main(String[] args) {
		
		IntersectionOfTwoUnsortedArrays a = new IntersectionOfTwoUnsortedArrays();
		
		int[] arr1 = {4,2,3,5,4,2,3};
		int[] arr2 = {9,1,7,2,4,2,1,2};
		
		
		Set<Integer> finalIntersection = new HashSet<>();
		
		a.intersectionOfTwoUnsortedArrays(arr1, arr2, finalIntersection);
		System.out.println(finalIntersection);
	}
	
	public void intersectionOfTwoUnsortedArrays(int[] arr1, int[] arr2, Set<Integer> finalIntersection) {
		int i = 0;
		int j = 0;
		
		Set<Integer> tempSet = new HashSet<>();
		
		while(i < arr1.length) {
			tempSet.add(arr1[i++]);
		}
		
		while(j < arr2.length) {
			if(tempSet.contains(arr2[j])) {
				finalIntersection.add(arr2[j]);
			}
			j++;
		}
	}

}
