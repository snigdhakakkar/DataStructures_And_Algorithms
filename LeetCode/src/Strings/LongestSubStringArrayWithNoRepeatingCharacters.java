package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringArrayWithNoRepeatingCharacters {
	
	public static void main(String[] args) {
		String str = "bccbababd";
		int k = 3;
		
		System.out.println(longestSubStringArrayWithNoRepeatingCharacters(str, k));
	}
	
	public static int longestSubStringArrayWithNoRepeatingCharacters(String str, int k) {
		if(str == null || str.length() == 0 ){
			return -1;
		}
		
		int max_Length = 0;
		int start, end;
		start = end = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		while(end < str.length()) {
			char currentChar = str.charAt(end);
			
			if(map.containsKey(currentChar)) {
				start = Math.max(start, map.get(currentChar) + 1);
			}
			
			map.put(currentChar, end);
			max_Length = Math.max(max_Length, end - start + 1);
			end++;
		}
		
		return max_Length;
	}

}
