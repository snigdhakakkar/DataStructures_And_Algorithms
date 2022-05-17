package recursion_and_dynamic_programming.Triple_step;

import java.util.Arrays;

/*
 * Due to repititive calls in recursive (bruteforce method),
 *  the time complexity was around O(3^n).
 *  
 *  In memoization, if we've seen the value of n before, we return the cached value. 
 *  Each time we compute a fresh value, we add it to the cache
 *  
 *  usually, we use a HashMap<Integer, Integer> for a cache.
 *  
 */

public class memoization_approach_triple_step {
	
	public static int countWays(int n) {
		int[] map = new int[n + 1];
		Arrays.fill(map, -1);
		return countWays(n, map);
	}
	
	public static int countWays(int n, int[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
			return memo[n];
		}
	}
	
	public static void main(String[] args) {
		int n = 50;
		int ways = countWays(n);
		System.out.println(ways);
	}

}
