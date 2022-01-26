package array;

public class MaximumProductOfAnyTwoNumbers {
	
	public static void main(String[] args) {
		
		MaximumProductOfAnyTwoNumbers m = new MaximumProductOfAnyTwoNumbers();
		
		int[] arr1 = {4,1,3,10,7,5,8,9};
		int[] arr2 = {-4,2,3,-10,4,-15,3,6};
		
		System.out.println(m.getMaxProductOfTwoNumbers(arr1));
		System.out.println(m.getMaxProductOfTwoNumbers(arr2));
	}
	
	public int getMaxProductOfTwoNumbers(int[] arr) {
		if(arr.length < 2) {
			return -1;
		}
		
		if(arr.length == 2) {
			return (arr[0] * arr[1]);
		}
		
		int smallest = arr[0] < arr[1] ? arr[0] : arr[1];
		int secondSmallest = arr[0] > arr[1] ? arr[0] : arr[1];
		
		int greatest = arr[0] > arr[1] ? arr[0] : arr[1];
		int secondGreatest = arr[0] < arr[1] ? arr[0] : arr[1];
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] < smallest) {
				secondSmallest = smallest;
				smallest = arr[i];
			} else if(arr[i] < secondSmallest) {
				secondSmallest = arr[i];
			}
			
			if(arr[i] > greatest) {
				secondGreatest = greatest;
				greatest = arr[i];
			} else if(arr[i] > secondGreatest) {
				secondGreatest = arr[i];
			}
		}
		
		int firstProduct = smallest * secondSmallest;
		int secondProduct = greatest * secondGreatest;
		
		return firstProduct > secondProduct ? firstProduct : secondProduct;
	}

}
