package Strings;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubStringWithAllCharactersOfPatternString {
	
	public static void main(String[] args) {
		String str = "badeaebcaae";
		String pattern = "aabc";
		
		SmallestSubStringWithAllCharactersOfPatternString a = new SmallestSubStringWithAllCharactersOfPatternString();
		
		System.out.println(a.smallestSubStringWithAllCharactersOfPattern(str, pattern));
	}
	
	public String smallestSubStringWithAllCharactersOfPattern(String str, String pattern) {
		if(str == null || str.length() == 0 || pattern == null || pattern.length() == 0) {
			return "";
		}
		
		Map<Character, Integer> map = new HashMap<>();
		
		int matchedElement = 0;
		int start = 0;
		int minSubStringLength = Integer.MAX_VALUE;
		int minSubStringStart = 0;
		
		for(int i = 0; i < pattern.length();  i++) {
			  map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
		  }
		
		for(int end = 0; end < str.length(); end++) {
			char currentChar = str.charAt(end);
			
			if(map.containsKey(currentChar)) {
				map.put(currentChar, map.get(currentChar) - 1);
				
				if(map.get(currentChar) >= 0) {
					  matchedElement++;
				  	}
			}
			
			while(matchedElement == pattern.length()) {
				if(end - start + 1 < minSubStringLength) {
					minSubStringLength = end - start + 1;
					minSubStringStart = start;
				}
				
				char charAtStart = str.charAt(start++);
				
				if(map.containsKey(charAtStart)) {
					  if(map.get(charAtStart) == 0) {
						  matchedElement--;
					  }
					  
					  map.put(charAtStart, map.get(charAtStart) + 1);
				}
			}
		}
		
		if(minSubStringLength > str.length()) {
			return "";
		}
		
		return str.substring(minSubStringStart, minSubStringStart + minSubStringLength);
	}

}
