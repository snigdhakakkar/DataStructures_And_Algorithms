package DynamicProgrammingProblems;

//Bruteforce approach is to compute sum for each increasing subsequence from each element in the array
//Time complexity: O(n^2)
//Space complexity: O(n)


public class MaxSumOfIncreasingSubSequence {
	
	public static void main(String[] args) {
		
		MaxSumOfIncreasingSubSequence a = new MaxSumOfIncreasingSubSequence();
		
		int arr[] = {7, 1, 4, 8, 11, 2, 14, 3};
		
		System.out.println(a.getMaxSumOfIncreasingSubsequence(arr));
	}
	  
	public int getMaxSumOfIncreasingSubsequence(int[] arr) {
		int[] mis = new int[arr.length];
		
		for(int i = 0; i < mis.length; i++) {
			mis[i] = arr[i];
		}
		
		int maxIncreasingSeqSum = arr[0];
		
		for(int i = 1; i < mis.length; i++) {
			for(int j = 0; j < i; j++) {
				
				if(arr[i] > arr[j] && arr[i] + mis[j] > mis[i]) {
					mis[i] = arr[i] + mis[j];
					
					maxIncreasingSeqSum = Math.max(maxIncreasingSeqSum, mis[i]);
				}
			}
		}
		
		return maxIncreasingSeqSum;
	}

}
