package DynamicProgrammingProblems;

public class MaxSumOfArrayElementsIfConsecutiveElementsNotAllowed {
	//max(including, excluding) = max(arr[i] + dp[i - 2], dp[i -1])
	
	//time complexity: O(n)
	//space complexity: O(n)
	public static void main(String[] args) {
		
		MaxSumOfArrayElementsIfConsecutiveElementsNotAllowed a = new MaxSumOfArrayElementsIfConsecutiveElementsNotAllowed();
		
		int[] arr = {4, 2, 3, 5, 1, 6, 7};
		
		System.out.println(a.maxSumIfConsecutiveElementsNotAllowed(arr));
	}  
	
	public int maxSumIfConsecutiveElementsNotAllowed(int[] arr) {
		
		if(arr.length == 0) {
			return 0;
		}
		
		if(arr.length == 1) {
			return arr[0];
		}
		
		int[] dp = new int[arr.length];
		
		dp[0] = arr[0];
		
		dp[1] = arr[0] > arr[1] ? arr[0] : arr[1];
		
		for (int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(dp[i -1], arr[i] + dp[i -2]);
		}
		
		return dp[arr.length - 1];   
	}
}
