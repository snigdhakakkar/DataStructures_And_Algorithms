package array;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingValueInArray {
	
	public static void main(String[] args) {
		FirstRepeatingValueInArray a = new FirstRepeatingValueInArray();
		
		int[] arr = {2 ,3 , 4 , 4 , 3 , 5, 7};
		
		System.out.println(a.firstRepeatValue(arr));
		
		
	}
	
	public int firstRepeatValue(int[] arr) {
		Set<Integer> s = new HashSet<>();
		int firstRepeatVal = -1;
		
		for(int i = arr.length - 1; i >= 0; i--) {
			if(s.contains(arr[i])) {
				firstRepeatVal = arr[i];
			} else {
				s.add(arr[i]);
			}
		}
		
		return firstRepeatVal;
	}
}
