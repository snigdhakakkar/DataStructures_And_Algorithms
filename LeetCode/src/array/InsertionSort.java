package array;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		int a[] = {5, 2, 14, 6, 3};
		
		InsertionSort i = new InsertionSort();
		i.print(a);
		
		i.insertionSort(a);
		
		i.print(a);
	}
	
	
	
	
	public void print(int a[]) {
		for(int k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
		System.out.println();
	}
	
	public void insertionSort(int[]  arr) {
		if(arr.length <= 1) {
			return;
		}
		
		for(int p = 1; p < arr.length; p++) {
			int key = arr[p]; 
			int z;
			
			for (z = p - 1; z >= 0 && arr[z] > key; z--) {
				arr[z + 1] = arr[z];
			}
			
			arr[z + 1] = key;
		}
	}



}
