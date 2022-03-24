package DynamicProgrammingProblems;

//Total number of ways = arr[i][j - coins[i] + arr[i - 1][j]
//time complexity: O(n^2) i.e. O(no. of coins * sum)
//space complexity: O(n^2) i.e. O(no. of coins * sum)
public class CoinChangeProblem {
	
	public static void main(String[] args) {
		
		CoinChangeProblem a = new CoinChangeProblem();
		
		int[] coins = {1, 2, 3};
		
		int sum = 5;
		
		System.out.println(a.getTotalWaysToMakeSumFromGivenCoins(coins, sum));
	}
	
	public int getTotalWaysToMakeSumFromGivenCoins(int[] coins, int sum) {
		
		if(coins.length <= 0 || sum <= 0) {
			return -1;
		}
		
		int numberOfCoins = coins.length;

		int[][] arr = new int[numberOfCoins][sum + 1];
		
		for(int i = 0; i < numberOfCoins; i++) {
			arr[i][0] = 1;
		}
		
		for(int i = 0; i < numberOfCoins; i++) {
			for(int j = 1; j <= sum; j++) {
				
				int includingCurrentCoin = 0;
				int exculdingCurrentCoin = 0;
				
				if(coins[i] <= j) {
					includingCurrentCoin = arr[i][j - coins[i]];
				}
				
				if(i > 0) {
					exculdingCurrentCoin =  arr[i - 1][j];
				}
				
				arr[i][j] = includingCurrentCoin + exculdingCurrentCoin;
			}
		}
		
		return arr[numberOfCoins - 1][sum];
	}

}
