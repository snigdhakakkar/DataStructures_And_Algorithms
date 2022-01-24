package array;

public class SelectionSort {
	
	public static void main(String[] args) {
		
		int a[] = {5, 2, 14, 6, 3};
		
		SelectionSort s = new SelectionSort();
		s.print(a);
		
		s.selectionSort(a);
		
		s.print(a);
	}

	public void print(int a[]) {
	for(int k = 0; k < a.length; k++) {
		System.out.print(a[k] + " ");
		}
	System.out.println();
	}
	
	public void selectionSort(int[] arr) {
		if(arr.length <= 1) {
			return;
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				int tmp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = tmp;
			}
		}
	}

}
