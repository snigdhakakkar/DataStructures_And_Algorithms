package DynamicProgrammingProblems;
//unbounded - repetition of coins is allowed
//need to find the minimum coins required for the given sum


//minimum coins = min(including, excluding)
//minimum coins = min(1 + arr[i][j - coins[i]], arr[i - 1][j])

//time complexity: O(n^2) i.e. O(no. of coins * sum)
//space complexity: O(n^2) i.e. O(no. of coins * sum)
public class MinCoinChangeProblem {
	
	public static void main(String[] args) {
		
		MinCoinChangeProblem a = new MinCoinChangeProblem();
		
		int[] coins = {1, 2, 3};
		
		int sum = 5;
		
		System.out.println(a.getMinNumberOfCoinsToMakeSum(coins, sum));
	}
	
	public int getMinNumberOfCoinsToMakeSum(int[] coins, int sum) {
		
		if(coins.length <= 0 || sum <= 0) {
			return 0;
		}
		
		int numberOfCoins = coins.length;

		int[][] arr = new int[numberOfCoins][sum + 1];
		
		for(int i = 0; i < numberOfCoins; i++) {
			arr[i][0] = 0;
		}
		
		for(int i = 0; i < numberOfCoins; i++) {
			for(int j = 1; j <= sum; j++) {
				
				int includingCurrentCoin = Integer.MAX_VALUE;
				int excludingCurrentCoin = Integer.MAX_VALUE;
				
				if(coins[i] <= j) {
					includingCurrentCoin = 1 + arr[i][j - coins[i]];
				}
				
				if(i > 0) {
					excludingCurrentCoin =  arr[i - 1][j];
				}
				
				arr[i][j] = Math.min(excludingCurrentCoin, includingCurrentCoin);
			}
		}
		
		return arr[numberOfCoins - 1][sum];
		
	}
}
