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
    
    public int[] countBitsI(int n) {
        //time complexity: O(n); space complexity: O(1)
        //Approach 2: DP + Most significant bit
        int[] ans = new int[n + 1];
        int x = 0;
        int b = 1;
        
        //[0,b) is calculated
        while (b <= n){
            // generate [b, 2b) or [b, n) from [0, b)
            while (x < b && x + b <= n){
                ans[x + b] = ans[x] + 1;
                ++x;
            }
            x = 0;//reset x
            b <<=1;//b = 2b
            
        }
        return ans;
    }
    
    public int[] countBitsII(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; ++x) {
            // x / 2 is x >> 1 and x % 2 is x & 1
            ans[x] = ans[x >> 1] + (x & 1); 
        }
        return ans;
    }
        

}
