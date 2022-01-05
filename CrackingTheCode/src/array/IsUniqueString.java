package array;

public class IsUniqueString {
	
	public static boolean isUniqueChars(String str) {
		if(str.length() > 128) { //Assuming that the string is an ASCII code and not a Unicode string
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
		for(String word:words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

} //Time complexity for the code is O(n), where n is the string length. Space complexity is O(1).
