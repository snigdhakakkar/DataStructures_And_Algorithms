package DynamicProgrammingProblems;

//Given an array, we need to find the longest increasing subsequence length
//Time complexity: O(n^2)
//Space complexity: O(n)

public class LongestIncreasingSubsequenceLength {
	
	public static void main(String[] args) {
		
		LongestIncreasingSubsequenceLength a = new LongestIncreasingSubsequenceLength();
		
		int arr[] = {7, 1, 4, 8, 11, 2, 14, 3};
		
		System.out.println(a.lisLength(arr));
	}  
	
	public int lisLength(int[] arr) {
		int[] lis = new int[arr.length];
		
		for(int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}
		
		int maxLisLength = 1;
		
		for(int i = 1; i < lis.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && 1 + lis[j] > lis[i]) {
					lis[i] = lis[j] + 1;
					
					maxLisLength = Math.max(maxLisLength, lis[i]);
				}
			}
		}
		
		return maxLisLength;
	}

}
