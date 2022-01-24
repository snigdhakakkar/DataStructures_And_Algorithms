package array;

public class InsertElementsInArray {
	
	int count = 0;
	public static void main(String[] args) {
		
		InsertElementsInArray k = new InsertElementsInArray();
		
		int a[] = new int[10];
		
		for (int j = 0; j < a.length-4; j++) {
			k.insert(a, j+1);
		}
		
		k.insert(a, 34);
		
		k.insertAtAGivenPosition(a, 3, 11);
		
		k.print(a);
		
	}
	
	public void insert(int a[], int value) {
		a[count++] = value;	
	}
	
	public void insertAtStart(int a[], int value) {
		
		for(int i = a.length -1 ; i > 0; i--) {
			a[i] = a[i-1];
		}
		
		a[0] = value;
	}
	
	public void insertAtAGivenPosition(int a[],int pos, int value) {
		
		for(int i = count - 1; i > pos; i--) {
			a[i] = a[i-1];
		}
		
		a[pos] = value;
	}
	
	public void print(int a[]) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
