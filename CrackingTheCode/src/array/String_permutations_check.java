package array;

import java.util.Arrays;

public class String_permutations_check {
	
	//Assumptions: permutation comparison is case sensitive and white space is significant in it
	//'God' is not a permutation of 'dog'
	//'god    ' is not a permutation of 'dog'
	
	         
	public static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean permutation(String s, String t) {
		
		if (s.length() != t.length()) {
			return false;
		}
		
		return sort(s).equals(sort(t));
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
	
	//time complexity depends upon the sorting algorithm used. Quicksort might take O(N^2) in worst case scenario and O(NlogN) usually if mergesort is used
}
