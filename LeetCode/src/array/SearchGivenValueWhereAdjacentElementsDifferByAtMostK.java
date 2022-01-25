package array;

public class SearchGivenValueWhereAdjacentElementsDifferByAtMostK {
	
	public int findWhereAdjacentDifferByAtMostK(int[] arr, int k, int val) {
		
		int start = 0;
		
		while(start < arr.length) {
			if(arr[start] == val) {
				return start;
			}
			
			int diff = Math.abs(arr[start] - val)/k;
			diff = Math.max(1, diff);
			
			start = start + diff;
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		SearchGivenValueWhereAdjacentElementsDifferByAtMostK a = new SearchGivenValueWhereAdjacentElementsDifferByAtMostK();
		
		int[] arr = {70,70,60,70,80,90,110,130};
		
		System.out.println(a.findWhereAdjacentDifferByAtMostK(arr, 20, 90));
		
	}

}
