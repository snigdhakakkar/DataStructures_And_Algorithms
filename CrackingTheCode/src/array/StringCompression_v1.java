package array;

public class StringCompression_v1 {
	
	public static String compressBad(String str) {
		String compressedString = "";
		int countConsecutive = 0;
		
		
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			/* If next character is different than current, 
			 * append this character to result */
			
			if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressedString += "" + str.charAt(i) + countConsecutive;
				countConsecutive = 0;
			}
		}
		      
		return compressedString.length() < str.length() ? compressedString : str;
	}
	
	public static void main(String[] args) {
		String str = "aabbbccwwwwqqqq";
		System.out.println(str);
		System.out.println(compressBad(str));
	}

	//time complexity: O(p +k^2) where p is the length / size of original string and k is the number of character sequences
	//it is slow because concatenation operation takes O(n^2)
}
