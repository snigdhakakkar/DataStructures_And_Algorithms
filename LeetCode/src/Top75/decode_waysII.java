package Top75;

/*
 * Problem statement - A message containing letters from A-Z can be encoded into 
 * numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into 
letters using the reverse of the mapping above (there may be multiple ways). 
For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 
'F' since "6" is different from "06".

In addition to the mapping above, an encoded message may contain the '*' character, 
which can represent any digit from '1' to '9' ('0' is excluded). 
For example, the encoded message "1*" may represent any of the encoded messages 
"11", "12", "13", "14", "15", "16", "17", "18", or "19". 
Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.

Given a string s consisting of digits and '*' characters, return the number of ways to
 decode it.

Since the answer may be very large, return it modulo 10^9 + 7.
 */

public class decode_waysII {
	//recursion with memoization approach
	//time complexity: O(N)as Size of recursion tree can go upto n, 
	//since memo array is filled exactly once. Here, n refers to the length of the
	//input string.; space complexity: O(N) which is the depth of the recursion tree
	 int M = 1000000007;
	    public int numDecodings(String s) {
	        Long[] memo = new Long[s.length()];
	        return (int) ways(s, s.length() - 1, memo);
	    }
	    
	    public long ways(String s, int i, Long[] memo){
	        if (i < 0)
	            return 1;
	        if (memo[i] != null)
	            return memo[i];
	        if (s.charAt(i) == '*'){
	            long res = 9 * ways(s, i - 1, memo) % M;
	            if (i > 0 && s.charAt(i - 1) == '1'){
	                res = (res + 9 * ways(s, i - 2, memo)) % M;
	            } else if (i > 0 && s.charAt(i - 1) == '2'){
	                 res = (res + 6 * ways(s, i - 2, memo)) % M;
	            } else if (i > 0 && s.charAt(i - 1) == '*'){
	                res = (res + 15 * ways(s, i - 2, memo)) % M;
	            }
	            
	            memo[i] = res;
	            return memo[i];
	        }
	        
	        long res = s.charAt(i) != '0' ? ways(s, i - 1, memo) : 0;
	        if (i > 0 && s.charAt(i - 1) == '1'){
	            res = (res + ways(s, i - 2, memo)) % M;
	        } else if (i > 0 && s.charAt(i - 1) == '2' && s.charAt(i) <= '6'){
	            res = (res + ways(s, i - 2, memo)) % M;
	        } else if (i > 0 && s.charAt(i - 1) == '*'){
	            res = (res + (s.charAt(i) <= '6' ? 2 : 1) * ways(s, i - 2, memo)) % M;
	        }
	        
	        memo[i] = res;
	        return memo[i];
	        
	        
	    }
	    
	    //DP Approach
	    //time compleity: O(N); space complexity: O(N)
	    public int numDecodingsI(String s) {
	        long[] dp = new long[s.length() + 1];
	        dp[0] = 1; //base case
	        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
	         for (int i = 1; i < s.length(); i++) {
	             if (s.charAt(i) == '*') {
	                 dp[i + 1] = 9 * dp[i] % M;
	                 if (s.charAt(i - 1) == '1'){
	                     dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
	                 } else if (s.charAt(i - 1) == '2') {
	                     dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
	                 } else if (s.charAt(i - 1) == '*') {
	                      dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
	                 }
	             } else {
	                 dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
	                 if (s.charAt(i - 1) == '1') {
	                     dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
	                 } else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
	                     dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
	                 } else if (s.charAt(i - 1) == '*') {
	                     dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
	                 }
	             }
	         }
	        
	         return (int) dp[s.length()];
	        
	    }
	    
	    //DP Approach with space optimization
	    //time complexity: O(N); Space complexity: O(1)
	    
	    public int numDecodingsII(String s) {
	        long first = 1, second = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
	        
	        for (int i = 1; i < s.length(); i++){
	            long temp = second;
	            if (s.charAt(i) == '*'){
	                second = 9 * second % M;
	                if (s.charAt(i - 1) == '1'){
	                    second = (second + 9 * first) % M;
	                } else if (s.charAt(i - 1) == '2'){
	                    second = (second + 6 * first) % M;
	                } else if (s.charAt(i - 1) == '*') {
	                    second = (second + 15 * first) % M;
	                }
	            } else {
	                second = s.charAt(i) != '0' ? second : 0;
	                if (s.charAt(i - 1) == '1'){
	                    second = (second + first) % M;
	                } else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'){
	                    second = (second + first) % M;
	                } else if (s.charAt(i - 1) == '*') {
	                    second = (second + (s.charAt(i) <= '6' ? 2 : 1) * first) % M;
	                }
	            }
	            
	            first = temp;
	        }
	        
	        return (int) second;
	        
	    }

}
