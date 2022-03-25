package DynamicProgrammingProblems;

//each value in the array represents the maximum no. of jumps it can take

//time complexity: O(n*n)
//space complexity: O(n)

public class MinJumpsToReachTheEnd {
	
	public static void main(String[] args) {
		
		MinJumpsToReachTheEnd a = new MinJumpsToReachTheEnd();
		
		int[] arr = {1, 2, 1, 3, 2, 1, 2, 1};
		
		System.out.println(a.minimumNumberOfJumps(arr));
	}
	
	public int minimumNumberOfJumps(int[] arr) {
		
		if(arr.length == 0) {
			return -1;
		}
		
		int[] minJumps = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			minJumps[i] = Integer.MAX_VALUE;
		}
		
		minJumps[0] = 0;
		
		for(int i = 0; i <= arr.length - 1; i++) {
			for(int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
				
				minJumps[j] = Math.min(1 + minJumps[i], minJumps[j]);
			}
		}
		
		return minJumps[arr.length - 1];
	}

}
