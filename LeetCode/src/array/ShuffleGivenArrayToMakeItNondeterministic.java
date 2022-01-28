package array;

import java.util.Random;

//shuffle given cards
public class ShuffleGivenArrayToMakeItNondeterministic {
	
	public static void main(String[] args) {
		
		ShuffleGivenArrayToMakeItNondeterministic a = new ShuffleGivenArrayToMakeItNondeterministic();
		
		int arr[] = {3, 7, 4, 1, 8, 9, 10};
		
		for(int i = 0; i < 10; i++ ) {
			shuffleNumbers(arr);
		}
				
		}
	
	public static void shuffleNumbers(int[] arr) {
		
		Random randomObject = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			
			int random_Value = randomObject.nextInt(arr.length);
			
			int current = arr[i];
			arr[i] = arr[random_Value];
			arr[random_Value] = current;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
	}
	
	

}
