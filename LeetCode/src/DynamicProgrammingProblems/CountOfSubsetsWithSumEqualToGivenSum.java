package DynamicProgrammingProblems;

public class CountOfSubsetsWithSumEqualToGivenSum {
	//columns in the arr[][] would be the sum we want to 
	//find count of subsets for and rows represent the number of elements we are taking
	
	//count = including + excluding
	//count = dp[i - 1][j - arr[i]] + dp[i - 1][j] , here the numbers cannot be repeated {not used multiple times}
	
	//time complexity: O(n*sum)
	//space complexity: O(n*sum)
	
	public static void main(String[] args) {
		
		CountOfSubsetsWithSumEqualToGivenSum a = new CountOfSubsetsWithSumEqualToGivenSum();
		
		int[] arr = {2, 3, 7, 1, 4, 5}; //array of subsets 
		int sum = 7; //given sum for which subsets need to be found
		
		System.out.println(a.getCountOfSubsetsForGivenSum(arr, sum));
		
	}
	
	public int getCountOfSubsetsForGivenSum(int[] arr, int sum) {
		
		if(arr.length == 0 || sum <= 0) {
			return 0;
		}
		
		int n = arr.length;
		
		int[][] count = new int[n][sum + 1];
		
		for(int i = 0; i < n ; i++) {
			count[i][0] = 1;
		}
		
		for(int j = 0; j <= sum; j++) {
			if(arr[0] == j) {
				count[0][j] = 1;
			}
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= sum; j++) {
				
				int includingCurrentValue = 0;
				int excludingCurrentValue = 0;
				
				if(arr[i] <= j) {
					includingCurrentValue = count[i - 1][j - arr[i]];
				}
				
				excludingCurrentValue = count[i - 1][j];
				
				count[i][j] = includingCurrentValue + excludingCurrentValue;
			}
		}
		
		return count[n - 1][sum];
		
	}

}
