package array;

//Kadane algorithm - this does not work if all the elements are negative

public class SubArrayWithMaxSum {
	
	public int findLargestSubArraySum(int[] arr) {
		if(arr.length == 0) {
			System.out.println("Array is empty.");
			return -1;
		}
		
		boolean ifPositiveExists = false;
		int max_element = Integer.MIN_VALUE;
		int max_sum = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				ifPositiveExists = true;
			}
			
			max_element = Math.max(arr[i], max_element);
			sum = sum + arr[i];
			
			if(sum < 0) {  //kadane algorithm
				sum = 0;
				continue;
			}
			
			max_sum = Math.max(max_sum, sum);
		}
		return ifPositiveExists ? max_sum : max_element;
	}
	
	public static void main(String[] args) {
		
		SubArrayWithMaxSum a = new SubArrayWithMaxSum();
		int[] arr1 = {4 ,2 , 5 , 2 ,1 , 8};
		int[] arr2 = {-12, -1, -13, 5, 4, 3, -1, 2};
		
		System.out.println(a.findLargestSubArraySum(arr1));
		System.out.println(a.findLargestSubArraySum(arr2));
	}

}
