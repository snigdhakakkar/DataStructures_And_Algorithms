package DynamicProgrammingProblems;

/*capacity of knapsack is given along with weights of things 
 * and profit associated with them.
 * It's a bounded knapsack that 
 * you can put single weight just one time
 */ 


public class ZeroOrOneKnapsackProblem {
	
	public static void main(String[] args) {
		
		ZeroOrOneKnapsackProblem a = new ZeroOrOneKnapsackProblem();
		
		int[] wt = {1, 2, 3, 5};
		int[] pr = {1, 4, 7, 10};
		
		int capacity = 8;
		
		System.out.println(a.KnapSackBottomUp(wt, pr, capacity));
		
	}
	
	//recursive approach
	/*time complexity: O(2^n) as there 
	is always a two-branched recursion in 0/1 knapsack*/
	
	
	// DP Bottom Up Approach
	//Including weight profit: Pr[i] + arr[i - 1][j - w[i]]
	//Excluding weight profit: arr[i - 1][j] for jth column
	//time complexity: O(n*capacity) where n is the number of weights
	//space complexity: O(n*capacity)
	public int KnapSackBottomUp(int[] wt, int[] pr, int c) {
		
		if(wt.length == 0 || pr.length == 0 || c <= 0) {
			return 0;
		}
		
		int[][] arr = new int[wt.length][c + 1];
		
		for(int j = 0; j <= c; j++) {
			if(wt[0] <= j) {
				arr[0][j] = pr[0];
			}
		}
		
		for(int i = 1; i < wt.length; i++) {
			for(int j = 1; j <= c; j++) {
				
				int includingProfit = 0;
				
				if(wt[i] <= j) {
					includingProfit = pr[i] + arr[i - 1][j - wt[i]];
				}
				
				arr[i][j] = Math.max(includingProfit, arr[i - 1][j]);
			}
		}
		
		return arr[wt.length - 1][c];
	}

}
