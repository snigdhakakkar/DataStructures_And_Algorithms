package DynamicProgrammingProblems;

//Unbounded - can use one weight multiple times

//DP Bottom Up Approach
//Including weight profit: Pr[i] + arr[i][j - w[i]]
//Excluding weight profit: arr[i - 1][j] for jth column
//time complexity: O(n*capacity) where n is the number of weights
//space complexity: O(n*capacity)
public class UnboundedKnacpsackProblem {
	
	public static void main(String[] args) {
		
		UnboundedKnacpsackProblem a = new UnboundedKnacpsackProblem();
		
		int[] wt = {1, 2, 3, 5};
		int[] pr = {1, 4, 7, 10};
		
		int capacity = 8;
		
		System.out.println(a.getMaxProfitUnboundedKnapSack(wt, pr, capacity));
	}
	
	public int getMaxProfitUnboundedKnapSack(int[] wt, int[] pr, int c) {
		
		if(wt.length == 0 || pr.length == 0 || c <= 0) {
			return 0;
		}
		
		int numberOfWeights = wt.length;
		
		int[][] arr = new int[numberOfWeights] [c + 1];
		
		for(int i = 0; i < wt.length; i++) {
			for(int j = 1; j <= c; j++) {
				
				int includingCurrentWeightProfit = 0;
				int exculdingCurrentWeightProfit = 0;
				
				if(wt[i] <= j) {
					includingCurrentWeightProfit = pr[i] + arr[i][j - wt[i]];
				}
				
				if(i > 0) {
					exculdingCurrentWeightProfit = arr[i - 1][j];
				}
				
				arr[i][j] = Math.max(exculdingCurrentWeightProfit, includingCurrentWeightProfit);
			}
		}
		
		return arr[numberOfWeights - 1][c];
	}
}
