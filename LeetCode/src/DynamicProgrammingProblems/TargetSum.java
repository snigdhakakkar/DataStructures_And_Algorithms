package DynamicProgrammingProblems;

//find the count of subsets whose sum equals to given target sum
//Any element can be +/-

//(sum+) - (sum-) = sum
//(sum+) + (sum-) = arr_elements_Sum
//adding the above two equations, sum+ = (sum + total_arr_elements_sum) / 2

public class TargetSum {
	
	public static void main(String[] args) {
		
		TargetSum a = new TargetSum();
		
		int[] arr = {1, 2, 1, 3};
		int sum = 3;
		
		System.out.println(a.ifTargetSumExists(arr, sum));
	}
	
	public int ifTargetSumExists(int[] arr, int sum) {
		if(arr.length == 0) {
			return 0;
		}
		
		int sumOfArrayElements = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sumOfArrayElements = sumOfArrayElements + arr[i];
		}
		
		if(sumOfArrayElements < sum || (sumOfArrayElements + sum) % 2 != 0) {
			return 0;
		}
		
		int sumToCheck = (sumOfArrayElements + sum) / 2;
		
		return countSubsetsWithTheSumEqualToGivenSum(arr, sumToCheck);
	}
	
	private int countSubsetsWithTheSumEqualToGivenSum(int[] arr, int sum) {
		
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
