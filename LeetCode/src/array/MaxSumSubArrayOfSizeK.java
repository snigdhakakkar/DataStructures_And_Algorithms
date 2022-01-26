package array;

public class MaxSumSubArrayOfSizeK {
	
	public static void main(String[] args) {
		
		MaxSumSubArrayOfSizeK a = new MaxSumSubArrayOfSizeK();
		
		int arr[] = {3,2,5,4,1,6,5};
		
		System.out.println(a.findSubArrayOfSizeKWithMaxSum(arr, 3));
	}
	
	public int findSubArrayOfSizeKWithMaxSum(int[] arr, int k) {
		if(arr.length == 0 || k <= 0) {
			return -1;
		}
		
		int sum = 0;
		int i;
		for(i = 0; i < k; i++) {
			sum = sum + arr[i];
		}
		
		int max_sum = sum;
		int start = 0;
		
		for(int j = i; j < arr.length; j++) {
			sum = sum + arr[j] - arr[start++];
			if(sum > max_sum) {
				max_sum = sum;
			}
		}
		
		return max_sum;
	}

}
