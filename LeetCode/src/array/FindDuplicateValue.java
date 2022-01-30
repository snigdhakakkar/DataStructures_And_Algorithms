package array;

public class FindDuplicateValue {
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,2,1};
		
		FindDuplicateValue a = new FindDuplicateValue();
		System.out.println(a.findDuplicate(arr));
	}
	
	public int findDuplicate(int[] arr) {
		if(arr.length <= 1) {
			return -1;
		}
		
		int i = 0;
		int arrMin = getMinValue(arr);
		
		while(i < arr.length){ //cyclic sort
			if(arr[i] != arr[arr[i] - arrMin]) {
				int destinationIndex = arr[i] - arrMin;
				
				int x = arr[i];
				arr[i] = arr[destinationIndex];
				arr[destinationIndex] = x;
				} else {
				i++;
			}
		}
		
		return arr[arr.length - 1];
	}
		

	
	public int getMinValue(int[] arr) {
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
				}
			}
			
		return min;
	}

}
