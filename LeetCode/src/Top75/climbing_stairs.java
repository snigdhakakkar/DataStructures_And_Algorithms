package Top75;

/*
 * Problem statement - You are climbing a staircase. 
 * It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top? 

1 <= n <= 45
 */

public class climbing_stairs {
	
	public int climbStairs(int n) {
        
        //Approach 1 - brute force approach
        
        //Time complexity : O(2^n); space complexity: O(n)
        
        return climb_Stairs(0, n);
    }       
    
    public int climb_Stairs(int i, int n){
        if (i > n) {
            return 0;
        }
        
        if (i == n) {
            return 1;
        }
        
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
    
 public int climbStairsI(int n) {
        
        //Approach 2 - recursion and memoization approach
        
        //Time complexity : O(n); space complexity: O(n)
        int memo[] = new int[n + 1];
        
        return climb_StairsI(0, n, memo);
    }
    
    public int climb_StairsI(int i, int n, int memo[]){
        if (i > n) {
            return 0;
        }
        
        if (i == n) {
            return 1;
        }
        
         if (memo[i] > 0) {
            return memo[i];
        }
        
        memo[i] =  climb_StairsI(i + 1, n, memo) + climb_StairsI(i + 2, n, memo);
        return memo[i];
    }
    
    public int climbStairsII(int n) {
        
        //Approach 3 - dynamic programming approach
        
        //Time complexity : O(n); space complexity: O(n)
        if (n == 1) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    public int climbStairsIII(int n) {
        
        //Approach 4 - fibonacci number approach
        
        //Time complexity : O(n); space complexity: O(n)
        if (n == 1) {
            return 1;
        }
        
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        
        return second;
    }

}
