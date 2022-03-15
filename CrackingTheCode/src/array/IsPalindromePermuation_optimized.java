package array;

public class IsPalindromePermuation_optimized {
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') -
		                      Character.getNumericValue('a') + 1];
		for (char ch: phrase.toCharArray()) {
			int x = getCharNumber(ch);
			
			if (x != -1) {
				table[x]++;
				
				if (table[x]%2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
				
			}
		}   
		return (countOdd <=1);
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
	
	//driver method
	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(isPermutationOfPalindrome(pali));
	}

}
