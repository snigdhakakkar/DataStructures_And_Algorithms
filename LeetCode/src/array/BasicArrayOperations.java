package array;

public class BasicArrayOperations {
	
	static int count = 0;
	
	public static void main(String[] args) {
		
		BasicArrayOperations k = new BasicArrayOperations();
		
		int a[] = new int[10];
		
		for (int j = 0; j < a.length-4; j++) {
			k.insert(a, j+1);
		}
		
		k.print(a);
		System.out.println();
		
		k.insert(a, 34);
		
		k.print(a);
		System.out.println();
		
		k.insertAtStart(a, 23);
		
		k.print(a);
		System.out.println();
		
		k.insertAtAGivenPosition(a, 3, 11);
		
		k.print(a);
		System.out.println();
		
		k.deleteFromEnd(a);
		
		k.print(a);
		System.out.println();
		
		k.deleteAValue(a, 3);
		
		k.print(a);
		System.out.println();
		
		k.deleteFromPosition(a, 3);
		
		k.print(a);
		System.out.println();
		
	}
	
	public void insert(int a[], int value) {
		a[count++] = value;	
	}
	
	public void insertAtStart(int a[], int value) {
		
		for(int i = a.length -1 ; i > 0; i--) {
			a[i] = a[i-1];
		}
		
		a[0] = value;
		count++;
	}
	
	public void insertAtAGivenPosition(int a[],int pos, int value) {
		
		for(int i = a.length - 1; i > pos; i--) {
			a[i] = a[i-1];
		}
		
		a[pos] = value;
		count++;
	}
	
	public static void deleteFromEnd(int a[]) {
		if(a.length == 0) {
			return;
		}
		
		count--;
	}
	
	public void deleteAValue(int a[], int value) {
		
		//check if the value is present in the array
		int i;
		
		for(i = 0; i < count; i++) {
			if(a[i] == value) {
				break;
			}
		}
		
		if(i == count) {
			System.out.println("Value does not exist in the array");
			return;
		}
		
		for(int j = i; j < count - 1; j++) {
			a[j] = a[j+1];
		}
		
		count--;
		
	}
	
	public void deleteFromPosition(int a[], int pos) {
		if(pos > count || pos <= 0) {
			System.out.println("Invalid position.");
			return;
		}
		
		for(int i = pos; i < count - 1; i++) {
			a[i] = a[i+1];
		}
		count--;
	}
	

	public void print(int a[]) {
		for(int i = 0; i < count; i++) {
			System.out.print(a[i] + " ");
		}
		
	}

}
