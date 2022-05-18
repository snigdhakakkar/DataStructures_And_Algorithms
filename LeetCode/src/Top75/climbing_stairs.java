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

}
