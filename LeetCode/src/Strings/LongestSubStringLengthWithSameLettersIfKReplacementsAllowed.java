package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringLengthWithSameLettersIfKReplacementsAllowed {
	
	public static void main(String[] args) {
		String str = "bcccbababd";
		int k = 2;
		
		LongestSubStringLengthWithSameLettersIfKReplacementsAllowed a = new LongestSubStringLengthWithSameLettersIfKReplacementsAllowed();
		
		System.out.println(a.longestSubStringLengthWithSameLettersIfKReplacementsAllowed(str, k));
	}
	
	public int longestSubStringLengthWithSameLettersIfKReplacementsAllowed(String str, int k) {
		if(str == null || str.length() == 0 || k <= 0 || k > str.length()) {
			return -1;
		}
		int start = 0;
		int end = 0;
		int maxFreq = 0;
		int maxLength = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		while(end < str.length()) {
			char currentChar = str.charAt(end);
			map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
			
			maxFreq = Math.max(maxFreq, map.get(currentChar));
			
			if(end - start + 1 - maxFreq > k) {
				char startChar = str.charAt(start);
				map.put(startChar, map.get(startChar) - 1);
				
				start++;
			}
			
			maxLength = Math.max(maxLength, end - start + 1);
			end++;
		}
		
		return maxLength;
	}

}
