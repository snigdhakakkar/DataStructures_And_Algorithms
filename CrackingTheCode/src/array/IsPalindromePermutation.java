package array;

public class IsPalindromePermutation {
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
   
	/*Check that no more than one character has an odd count*/
	public static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				
				foundOdd = true;
			}
		}
		
		return true;
	}    
	
	/*Mapping each character to a number, for example a->0; b -> 1; c->2 etc.*/
	/*Assumption: this is case insensitive. Non-letter characters map to -1 */
	public static int getCharNumber(Character ch) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(ch);
		if (a <= val && val <=z ) {
			return val - a;
		}
		
		return -1;
	}
	
	/*Count how many times each character appears.*/
	public static int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') -
		                      Character.getNumericValue('a') + 1];
		
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
			}
		}
		return table;
	}
	
	//driver method
	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(isPermutationOfPalindrome(pali));
	}
	
	//time complexity: O(N)
}
