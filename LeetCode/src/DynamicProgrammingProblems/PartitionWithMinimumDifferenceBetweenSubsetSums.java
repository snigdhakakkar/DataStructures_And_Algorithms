package DynamicProgrammingProblems;

public class PartitionWithMinimumDifferenceBetweenSubsetSums {
	//time complexity = O(n^2)
	//space complexity = O(n^2)
	
	public static void main(String[] args) {
		
		PartitionWithMinimumDifferenceBetweenSubsetSums a = new PartitionWithMinimumDifferenceBetweenSubsetSums();
		
		int[] arr = { 1, 2, 3, 5, 13};
		
		System.out.println(a.getMinDifferenceSubsetSumArrayPartition(arr));
	}
	
	public int getMinDifferenceSubsetSumArrayPartition(int[] arr) {
		
		if(arr.length == 0) {
			return -1;
		}
		
		int sumOfArray = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sumOfArray = sumOfArray + arr[i];
		}
		
		int sum = sumOfArray/2;
		
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
		
		int lastRow = arr.length - 1;
		int firstPartitionSum = -1;
		
		for(int j = sum; j >= 0; j --) {
			if(mat[lastRow][j]) {
				firstPartitionSum = j;
				break;
			}
		}
		
		int secondPartitionSum = sumOfArray - firstPartitionSum;
		
		return Math.abs(secondPartitionSum - firstPartitionSum);
	}

}
