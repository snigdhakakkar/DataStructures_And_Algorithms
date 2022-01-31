package Strings;

import java.util.HashSet;
import java.util.Set;

public class FindNumberOfUniqueCharacters {
	
	public static void main(String[] args) {
		String str = "aaacbaddse";
		
		System.out.println(findUniqueCharacters(str));
	}
	
	public static int findUniqueCharacters(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		Set<Character> set = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}
		
		return set.size();
	}

}
