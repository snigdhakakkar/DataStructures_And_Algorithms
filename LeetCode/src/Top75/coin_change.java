package Top75;

import java.util.Arrays;

/*
 * Problem statement - You are given an integer array coins representing coins of different denominations 
 * and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
*/

public class coin_change {
	
	public int coinChange(int[] coins, int amount) {
        //Approach 1: Bruteforce approach - recursion
        //Space complexity: O(S) where S is the given amount; time complexity: O(S^N) where N is the number of denomination s
        return recursionHelper(coins, amount);
    }
    
    private int recursionHelper(int[] coins, int remain){
        //base cases
        if (remain < 0) {
            return -1;
        }
        
        if (remain == 0) {
            return 0;
        }
        
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = recursionHelper(coins, remain - coin);
            if (count == -1) {
                continue;
            }
            minCount = Math.min(minCount, count + 1);
        }
        
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
    
    private Integer[] memo;
    public int coinChangeI(int[] coins, int amount) {
        //Approach 2: Recursion with memoization approach
        //Space complexity: O(S) where S is the given amount; time complexity: O(S*N) where N is the number of denomination s
        memo = new Integer[amount+ 1];
        return recursionHelperI(coins, amount);
    }
    
    private int recursionHelperI(int[] coins, int remain){
        //base cases
        if (remain < 0) {
            return -1;
        }
        
        if (remain == 0) {
            return 0;
        }
        
        if(memo[remain] != null) {
            return memo[remain];
        }
        
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = recursionHelperI(coins, remain - coin);
            if (count == -1) {
                continue;
            }
            minCount = Math.min(minCount, count + 1);
        }
        
        memo[remain] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        
        return memo[remain];
    }
    
    public int coinChangeII(int[] coins, int amount) {
        //Approach 3: Dynamic Programming Bottom Up approach
        //Space complexity: O(S) where S is the given amount; time complexity: O(S*N) where N is the number of denomination s
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0; //base case
        for(int i = 1; i <= amount; i++){
            for(int coin: coins){
                if(i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1) ;
            }
        }
        
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

}
