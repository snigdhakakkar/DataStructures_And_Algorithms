package array;

public class SegregateOddAndEvenNumbers {
	
	public static void main(String[] args) {
		int[] arr = {2, 4, 1, 6, 3, 8, 7};
		
		SegregateOddAndEvenNumbers a = new SegregateOddAndEvenNumbers();
		
		a.segregateOddAndEven(arr);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void segregateOddAndEven(int[] arr) {
		if(arr.length == 0) {
			return;
		}
		
		int left, right;
		left = 0;
		right = arr.length - 1;
		
		while(left < right) {
			while(arr[left] % 2 == 0 && left < right) {
				left++;
			}
			
			while(arr[right] % 2 != 0 && left < right) {
				right--;
			}
			
			if(left < right) {
				int x = arr[left];
				arr[left] = arr[right];
				arr[right] = x;
				
				left++;
				right--;
			}
		}
	}
 	
	

}
