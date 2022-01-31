package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringLengthWithKDistinctCharacters {
	
	public static void main(String[] args) {
		String str = "bccbababd";
		int k = 3;
		
		System.out.println(longestSubStringLengthWithKDistinctCharacters(str, k));
	}
	
	public static int longestSubStringLengthWithKDistinctCharacters(String str, int k) {
		if(str == null || str.length() == 0 || k <= 0|| k > str.length()){
			return -1;
		}
		
		int max_Length = 0;
		int start, end;
		start = end = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		while(end < str.length()) {
			char currentChar = str.charAt(end);
			map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
			
			while(map.size() > k) {
				char charFromFront = str.charAt(start);
				map.put(charFromFront, map.get(charFromFront) - 1);
				
				if(map.get(charFromFront) == 0) {
					map.remove(charFromFront);
				}
				
				start++;
			}
			max_Length = Math.max(max_Length, end - start + 1);
			end++;
		}
		
		return max_Length;
		
	}

}
