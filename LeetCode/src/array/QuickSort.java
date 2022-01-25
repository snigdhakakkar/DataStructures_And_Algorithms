package array;

public class QuickSort {
	
	public static void main(String[] args) {
		
		int a[] = {12, 8, 30, 6, 15, 2, 1, 18 };
		
		QuickSort q = new QuickSort();
		
		q.print(a);
		q.quickSort(a, 0, a.length - 1);
		q.print(a);
	}

	public void print(int a[]) {
	for(int k = 0; k < a.length; k++) {
		System.out.print(a[k] + " ");
	}
	System.out.println();
	}
	
	public void quickSort(int arr[], int start, int end) {
		int pivot, j,i, temp;
		
		if(start < end) {
			pivot = start;
			i = start;
			j = end;
			
			while(i < j) {
				while(arr[i] <= arr[pivot] && i < end) {
					i++;}
				while(arr[j] > arr[pivot] && j >= start) {
					j--;}
						
				if(i<j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
			temp = arr[pivot];
			arr[pivot] = arr[j];
			arr[j] = temp;
			
			quickSort(arr, start, j - 1);
			quickSort(arr, j + 1, end);
		}
	}
}
