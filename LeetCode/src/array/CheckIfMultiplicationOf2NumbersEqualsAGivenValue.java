package array;

import java.util.HashSet;


//time complexity = O(N) ; Space complexity = O(N)

public class CheckIfMultiplicationOf2NumbersEqualsAGivenValue {
	
	public static void main(String[] args) {
		
		
		CheckIfMultiplicationOf2NumbersEqualsAGivenValue m = new CheckIfMultiplicationOf2NumbersEqualsAGivenValue();
		
		int[] arr = {4,1,3,10,7,5,8,9};
		
		
		
		System.out.println(m.checkIfProductOfPairMatchesGivenValue(arr, 15));
	}
	
	public boolean checkIfProductOfPairMatchesGivenValue(int[] arr, int val) {
		HashSet<Integer> s = new HashSet<>();
		
		for(int i = 0; i < arr.length; i++) {
			
			if(val % arr[i] == 0 && s.contains(val / arr[i])) {
				return true;
			}
			
			s.add(arr[i]);
		}
		
		return false;
	}

}
