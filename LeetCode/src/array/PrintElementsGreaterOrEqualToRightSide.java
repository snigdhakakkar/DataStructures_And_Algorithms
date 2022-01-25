package array;

public class PrintElementsGreaterOrEqualToRightSide {
	
	public static void main(String[] args) {
		
		PrintElementsGreaterOrEqualToRightSide p = new PrintElementsGreaterOrEqualToRightSide();
		
		int arr[] = {14, 15, 8, 9, 5, 2};
		
		p.printElementsGreaterOrEqualToRightSide(arr);
	}
	
	public void printElementsGreaterOrEqualToRightSide(int[] a) {
		int max = Integer.MIN_VALUE;
		
		for(int i = a.length -1; i >= 0; i--) {
			if(a[i] > max) {
				max = a[i];
				System.out.println(a[i] + " ");
			}
		}
	}

}
