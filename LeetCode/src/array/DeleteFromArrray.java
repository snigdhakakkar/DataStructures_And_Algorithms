package array;

public class DeleteFromArrray {
	
	static int count = 5;
	
	public static void main(String[] args) {
		int a[] = {23, 45, 56, 54, 32};
		
		DeleteFromArrray d = new DeleteFromArrray();
		
		d.print(a);
		System.out.println();
		
		d.deleteFromEnd(a);
		
		d.print(a);
		System.out.println();
		
		d.deleteAValue(a, 56);
		
		d.print(a);
		System.out.println();
		
		d.deleteFromPosition(a, 3);
		
		d.print(a);
		System.out.println();
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
		
		for(int i = pos - 1; i < count - 1; i++) {
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
