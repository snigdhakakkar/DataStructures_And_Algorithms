package array;

public class CyclicSortElementsFrom1ToN {
	
	public static void main(String[] args) {
		int[] arr1 = {3, 4, 6, 2, 1, 5};
		int[] arr2 = {13, 14, 16, 12, 11, 15};
		
		CyclicSortElementsFrom1ToN a = new CyclicSortElementsFrom1ToN();
		
		for(int i = 0; i < arr1.length; i++ ) {
			System.out.print(arr1[i] + " ");
			}
		
		System.out.println();
		
		a.cyclicSort(arr1);
		
		for(int i = 0; i < arr1.length; i++ ) {
			System.out.print(arr1[i] + " ");
			}
		
		System.out.println();
		
		for(int i = 0; i < arr2.length; i++ ) {
			System.out.print(arr2[i] + " ");
			}
		
		System.out.println();
		
		a.cyclicSort(arr2);
		
		for(int i = 0; i < arr2.length; i++ ) {
			System.out.print(arr2[i] + " ");
			}
		
		System.out.println();
		
	}
	
	public void cyclicSort(int[] arr) {
		if(arr.length <= 1) {
			return;
		}
		
		int arrMin = getMinValue(arr);
		
		int i = 0;
		while(i < arr.length) {
			if(arr[i] - arrMin != i) {
				int destinationIndex = arr[i] - arrMin;
				
				int x = arr[i];
				arr[i] = arr[destinationIndex];
				arr[destinationIndex] = x;
			} else {
				i++;
			}
		}
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
