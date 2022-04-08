package array;

import java.util.Arrays;

public class IsUniqueString {
	
	//Approach 1:
	public static boolean isUniqueChars(String str) {
		if(str.length() > 128) { //Assuming that the string is an ASCII code and not a UniCode string
			return false;
		}   
		
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			
			if(char_set[val]) { //Already found this char in string
				return false;
			} 
			
			char_set[val] = true;
		}
		   
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		//Approach 1
		for(String word:words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
		//Approach 2
		for(String word:words) {
			System.out.println(word + ": " + uniqueCharacters(word));
		}
	}
	
	//Approach 2:
	public static boolean uniqueCharacters(String str) {
		
		char[] chArray = str.toCharArray();
		/* Convert the string to character array
	       for sorting */
		
		// Using sorting
        // Arrays.sort() uses binarySort in the background
        // for non-primitives which is of O(nlogn) time complexity
        Arrays.sort(chArray);
        
        for (int i = 0; i < chArray.length - 1; i++) {
            // if the adjacent elements are not
            // equal, move to next element
            if (chArray[i] != chArray[i + 1])
                continue;
 
            // if at any time, 2 adjacent elements
            // become equal, return false
            else
                return false;
        }
        return true;
        
	}

} //Time complexity for the code is O(n), where n is the string length. Space complexity is O(1).

/*If we do not use additional data structures, then we would need to compare every character of the string to 
every other character. This will take O(n^2) time and O(1) space.*/

/*If we can modify the input string, then we can also sort the string and look for duplicate neighboring
 characters. This sorting might take additional space though. The time complexity 
 for this would be O(nlogn).*/
