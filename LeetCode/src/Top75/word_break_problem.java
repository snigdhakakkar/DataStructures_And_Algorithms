package Top75;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem statement - Given a string s and a dictionary of strings wordDict, 
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.


 */

public class word_break_problem {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        
        //Approach 1: brute force - recursion and backtracking
        /*For finding the solution, we check every possible prefix of that string in the dictionary of words, if it is found in the dictionary, then the recursive function is called for the remaining portion of that string. And, if in some function call it is found that the complete string is in dictionary, then it will return true
        */
		
		//time complexity: O(2^n); where n is the length of the string as there would be n+1 ways to split the string. At each step we would have two choices - to split or not to split. In the worst case, when all the choices are to be checked, the result is O(2^n)
	    
	    //space complexity: O(n)
        
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }
    
    private boolean wordBreakRecur(String s, Set<String> wordDict, int start){
        if (start == s.length()) {
            return true;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean wordBreakI(String s, List<String> wordDict) {
        
        //Approach 2: memoization
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
        
       
    }
    
    private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        
         if (memo[start] != null) {
            return memo[start];
        }
        
        for (int end = start + 1; end <= s.length(); end++){
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)){
                 return memo[start] = true;
            }
        }
        
         return memo[start] = false;
    }
    //time complexity: O(n^3); where n is the length of the string; size of the recursion tree can go up to n^2
    
    //space complexity: O(n)
    
    public boolean wordBreakIII(String s, List<String> wordDict) {
        
        //Approach 3: dynamic programming
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){ //end pointer
            for(int j = 0; j < i; j++){ //start pointer
                if (dp[j]
                   && wordDictSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            } 
        }
        
        return dp[s.length()];
    }
    
    
    //time complexity: O(n^3); where n is the length of the string; size of the recursion tree can go up to n^2
    
    //space complexity: O(n)

}
