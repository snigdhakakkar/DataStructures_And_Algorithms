package array;

public class FindMissingNumberFrom1ToNPlus1 {
	
	public static void main(String[] args) {
		
		FindMissingNumberFrom1ToNPlus1 a = new FindMissingNumberFrom1ToNPlus1();
		int[] arr = {3, 4, 6, 2, 1};
		System.out.print(a.findMissingElement(arr));
	}
	
	public int findMissingElement(int[] arr) {
		if(arr.length <= 1) {
			return -1;
		}
		int arrMin = getMinValue(arr);
		int i = 0;
		
		while(i < arr.length){ //cyclic sort
			
			if(arr[i] <= arr.length && arr[i] - arrMin != i) {
				int destinationIndex = arr[i] - arrMin;
				int x = arr[i];
				arr[i] = arr[destinationIndex];
				arr[destinationIndex] = x;
				} else {
				i++;
			}
		}
		
		for(i = 0; i < arr.length; i++) {
			if(arr[i] != i + arrMin) {
				return i + arrMin;
			}
		}
		
		return -1;
	}
		
	public int getMinValue(int[] arr) {
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
				}
			}
			
		return min;
	}

}
