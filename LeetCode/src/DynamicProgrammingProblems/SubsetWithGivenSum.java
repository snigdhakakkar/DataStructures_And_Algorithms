package DynamicProgrammingProblems;

public class SubsetWithGivenSum {
	
	public static void main(String[] args) {
		
		SubsetWithGivenSum a = new SubsetWithGivenSum();
		
		int[] arr = {1, 2, 3, 5};
		int givenSum = 7;
		
		System.out.println(a.isSubsetExists(arr, givenSum));
		
		
	}
	
	//recursive approach
	//time complexity: O(2^n)
	
	//DP Bottom up solution
	//time complexity: O(n*sum) where n is the number of elements in the array
	//space complexity: O(n*sum)
	//check matrix[i - 1][j - arr[i]]
	
	public boolean isSubsetExists(int[] arr, int sum) {
		
		if(arr.length == 0) {
			return false;
		}
		
		boolean[][] mat = new boolean[arr.length][sum + 1];
		
		for(int i = 0; i < arr.length; i++) {
			mat[i][0] = true;
		}
		
		for(int j = 0; j <= sum; j++) {
			if(j == arr[0]) {
				mat[0][j] = true;
			}
		}
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = 1; j <= sum; j++) {
				
				if(mat[i - 1][j]) {
					mat[i][j] = true;
				} else {
					if(j >= arr[i]) {
						mat[i][j] = mat[i - 1][j - arr[i]];
					}
				}
			}
		}
		
		return mat[arr.length - 1][sum];
	}

}
