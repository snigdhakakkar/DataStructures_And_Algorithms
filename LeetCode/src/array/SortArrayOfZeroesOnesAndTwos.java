package array;

public class SortArrayOfZeroesOnesAndTwos {
	
	public static void main(String[] args) {
		
		SortArrayOfZeroesOnesAndTwos s = new SortArrayOfZeroesOnesAndTwos();
		
		int arr[] = {0, 1, 1, 0, 2, 2, 1, 0, 2};
		s.print(arr);
		
		s.sortedArray(arr);
		
		s.print(arr);
		
	}
	
	public void print(int a[]) {
		for(int k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
		System.out.println();
		}
	
	public void sortedArray(int a[]) {
		int low, mid, high;
		low = mid = 0;
		high = a.length - 1;
		
		while(mid <= high) {
			switch(a[mid]) {
			case 0:
				if(a[low] != a[mid]) {
					int tmp = a[low];
					a[low] = a[mid];
					a[mid] = tmp;
				}
				low++;
				mid++;
				break;
				
			case 1:
				mid++;
				break;
				
			case 2:
				if(a[mid] != a[high]) {
					int t = a[mid];
					a[mid] = a[high];
					a[high] = t;
				}
				high--;
			}

		}
	}

}
