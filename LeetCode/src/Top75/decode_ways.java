package Top75;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem statement: A message containing letters from A-Z can be encoded into 
 * numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back 
into letters using the reverse of the mapping above (there may be multiple ways). 
For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' 
since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.


 */

public class decode_ways {
	
	//recursion with memoization approach
	//time complexity: O(N)where N is the length of the string. 
	//Memoization helps in pruning the recursion tree and hence decoding for an index only once. 
	//Thus this solution is linear time complexity.
	
	//space complexity: O(N).The dictionary used for memoization would take the space 
	//equal to the length of the string. There would be an entry for each index value. 
	//The recursion stack would also be equal to the length of the string.
	
	 Map<Integer, Integer> memo = new HashMap<>();
	    
	    public int numDecodings(String s) {
	        return recursiveWithMemo(0, s);
	    }
	    
	    public int recursiveWithMemo(int index, String str){
	        if(memo.containsKey(index)){
	            return memo.get(index);
	        }
	        //If you reach the end of the string
	        // Return 1 for success.
	        if (index == str.length()){
	            return 1;
	        }
	        
	        // If the string starts with a zero, it can't be decoded
	        if (str.charAt(index) == '0') {
	            return 0;
	        }
	        
	        if (index == str.length() - 1) {
	            return 1;
	        }
	        
	        int ans = recursiveWithMemo(index + 1, str);
	        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
	             ans += recursiveWithMemo(index + 2, str);
	         }

	        // Save for memoization
	        memo.put(index, ans);

	        return ans;
	    }

}
