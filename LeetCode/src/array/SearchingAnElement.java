package array;

public class SearchingAnElement {
	
	public static void main(String[] args) {
		int a[] = {12, 34, 45, 6, 13};
		
		SearchingAnElement s = new SearchingAnElement();
		
		int i = searchIndex(a, 34);
		
		if(i == -1) {
			System.out.println("value does not exist in the array.");
		} else {
			System.out.println(i);
		}
		
	}
	
	public static int searchIndex(int[] a, int val) {
		if(a.length == 0) {
			return -1;
		}
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] == val) {
				return i;
			}
		}
		
		return -1;
	}

}
