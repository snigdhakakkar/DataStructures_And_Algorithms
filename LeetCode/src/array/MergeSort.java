package array;

//divide and conquer approach
public class MergeSort {

	public static void main(String[] args) {
		
		int a[] = {12, 5, 3, 11, 14};
		MergeSort m = new MergeSort();
		
		m.print(a);
		m.mergeSort(a, 0, a.length - 1);
		m.print(a);
	}
	
	public void print(int a[]) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	//Time complexity: each step the array is divided into two
	//Binary parts, thus logN steps overall
	//Merging occurs after checking N elements
	//Hence, time complexity: NlogN
	public void mergeSort(int arr[], int start, int end) {
		if(start != end) {
			int mid  = (start + end) /2 ;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
	
	private void merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = 0;
		
		int[] temp = new int[end - start + 1];
		
		while((i <= mid) && (j <= end)) {
			if(arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
			
		while(i <= mid) {
			temp[k++] = arr[i++];
		}
			
		while(j <= end) {
				temp[k++] = arr[j++];
		}
			
		for(i = start; i <= end; i++) {
				arr[i] = temp[i - start];
		}
	}
}
