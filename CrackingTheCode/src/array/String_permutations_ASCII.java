package array;

public class String_permutations_ASCII {
	
	//Assumptions: permutation comparison is case sensitive and white space is significant in it
		//'God' is not a permutation of 'dog'
		//'god    ' is not a permutation of 'dog'
		
		
		public static boolean permutation(String s, String t) {
			
			if (s.length() != t.length()) {
				return false;
			}
			
			int[] letters = new int[128]; //Assuming that it is ASCII code
			for (int i = 0; i < s.length(); i++) {
				letters[s.charAt(i)]++;
			}
			
			for (int i = 0; i < t.length(); i++) {
				letters[t.charAt(i)]--;
				
				if (letters[t.charAt(i)] < 0) {
					return false;
				}
			}
			      
			return true; //letters has no negative values, and thus no positive values either
		}
		
		public static void main(String[] args) {
			String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
			
			for(String[] pair:pairs) {
				String word1 = pair[0];
				String word2 = pair[1];
				boolean anagram = permutation(word1, word2);
				System.out.println(word1 + ", " + word2 + ": " + anagram);
			}
		}
		
		//time complexity: O(N) 

}
