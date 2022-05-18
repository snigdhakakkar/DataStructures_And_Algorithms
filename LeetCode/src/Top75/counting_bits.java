package Top75;
/*
 * Problem statement - Given an integer n, return an array ans of length n + 1 
 * such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary 
 * representation of i.
 * 
 * It is very easy to come up with a solution with a runtime of O(n log n). 
 * Can you do it in linear time O(n) and possibly in a single pass?
 */
public class counting_bits {
	
	public int[] countBits(int n) {
        //time complexity: O(nlogn); space complexity: O(1)
        //Approach 1: Pop count or hamming weight
        int[] ans = new int[n + 1];
        for (int x = 0; x <= n; ++x) {
            ans[x] = popCount(x);
        }
        return ans;
        
    }
        
    private int popCount(int x) {
        int count = 0;
        while (x != 0) {
            count++;
            x &= x - 1; // zeroing out the least significant nonzero bit
        }
        return count;
    }


}
