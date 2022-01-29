package array;

public class SquareOfPositiveAndNegativeNumbersInASortedArray {
	
	public static void main(String[]  args) {
		int[] arr = {-4, -2, -1, 3, 5};
		
		int[] squareArr = squareInSortedManner(arr);
		
		for(int i = 0; i < squareArr.length; i++) {
			System.out.print(squareArr[i] + " ");
		}
	}
	
	public static int[] squareInSortedManner(int[] arr) {
		int[] squareArr = new int[arr.length];
		int i = arr.length - 1;
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start <=  end){
			if(arr[start] * arr[start] > arr[end] * arr[end]) {
				squareArr[i--] = arr[start] * arr[start];
				start++;
			} else {
				squareArr[i--] = arr[end] * arr[end];
				end--;
			}
		}
		return squareArr;
	}

}
