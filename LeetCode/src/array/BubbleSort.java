package array;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int a[] = {12, 5, 3, -1};
		
		BubbleSort b = new BubbleSort();
		b.print(a);
		b.bubbleSort(a);
		b.print(a);
 }
	
	public void bubbleSort(int a[]) {
		if(a.length == 0 || a.length == 1) {
			return;
		}
		
		for(int i = 0; i < a.length - 1; i++) {
			for(int j =0; j < a.length - 1 - i; j++) {
				if(a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
		 
	}
	
	public void print(int a[]) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
