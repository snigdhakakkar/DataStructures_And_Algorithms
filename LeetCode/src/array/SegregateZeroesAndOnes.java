package array;

public class SegregateZeroesAndOnes {
	
	public static void main(String[] args) {
		int[] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1};
		
		SegregateZeroesAndOnes a = new SegregateZeroesAndOnes();
		
		a.segregateZeroesAndOnes(arr);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void segregateZeroesAndOnes(int[] arr) {
		if(arr.length == 0) {
			return;
		}
		
		int left, right;
		left = 0;
		right = arr.length - 1;
		
		while(left < right) {
			while(arr[left] == 0 && left < right) {
				left++;
			}
			
			while(arr[right] != 0 && left < right) {
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
