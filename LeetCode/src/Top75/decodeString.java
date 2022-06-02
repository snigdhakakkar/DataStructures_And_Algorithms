package Top75;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Problem statement: Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the 
square brackets is being repeated exactly k times. Note that k is guaranteed 
to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces,
 square brackets are well-formed, etc. Furthermore, you may assume that 
 the original data does not contain any digits and that digits are 
 only for those repeat numbers, k. For example, there will not be input 
 like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
 */

public class decodeString {
	
	//Approach 1 : using stack
	/*
	 * Time Complexity: O(maxK^countK⋅n), where maxK is the maximum value of 
k, countK is the count of nested k values and n is the maximum length of encoded string. 
Example, for s = 20[a10[bc]], maxK is 20, countK is 2 as there are 2 nested 
k values (20 and 10) . Also, there are 2 encoded strings a and bc with 
maximum length of encoded string ,n as 2.

Space complexity: O(sum(maxK^countK⋅n))

max_stack size would be equivalent to the sum of all the decoded strings in the form 
maxK[nmaxK[n]]
	 */
	
	public String decodeString(String s) {
        //Approach 1: Using Stack
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ']') {
                List<Character> decodedString = new ArrayList<>();
                // get the encoded string
                while (stack.peek() != '['){
                    decodedString.add(stack.pop());
                }
                
                // pop [ from the stack
                stack.pop();
                int base = 1;
                int k = 0;
                // get the number k
                while (!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                
                // decode k[decodedString], by pushing decodedString k times into stack
                while (k != 0){
                    for (int j = decodedString.size() - 1; j >= 0; j--){
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
            }
            
            // push the current character to stack
            else {
                stack.push(s.charAt(i));
            }
            
        }
           
        // get the result from stack
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        
        return new String(result);
    }
	
	public String decodeStringI(String s) {
        //Approach 2: Using count Stack and string stack separately
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        
        int k = 0;
        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                // push the number k to countStack
                countStack.push(k);
                // push the currentString to stringStack
                stringStack.push(currentString);
                // reset currentString and k
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']'){
                StringBuilder decodedString = stringStack.pop();
                // decode currentK[currentString] by appending currentString k times
                
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
	
	/*time complexity: O(maxK.n) as We traverse a string of size n and iterate 
	k times to decode each pattern of form k[string]; space complexity : O(m + n) 
	where m is the number of letters (a-z) and n is the number of digits (0-9) in string s
	*/

}
