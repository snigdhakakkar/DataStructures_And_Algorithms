package Top75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem statement: Given an array of strings strs, group the anagrams together. 
 * You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different 
word or phrase, typically using all the original letters exactly once.
 */

public class group_anagrams {
	
	//Approach 1: Categorize by Sorted String
	//time complexity: O(N * KlogK) where N is the number of strings in array and 
	//K is the length of largest string
	//space complexity: O(N * K)
	public List<List<String>> groupAnagrams(String[] strs) {
        
		if (strs.length == 0) {
        	return new ArrayList();
        	}
        
        Map<String, List> ans = new HashMap<String, List>();
        
        for (String s : strs) {
            char[] ca = s.toCharArray();
            
            Arrays.sort(ca);
            
            String key = String.valueOf(ca);
            
            if (!ans.containsKey(key)) {
            	ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
            
        }
        
        return new ArrayList(ans.values());
    }
	
	//Approach 2: Categorize by Count
	//Time complexity: O(N*K)
	//Space complexity: O(N*K)
	public List<List<String>> groupAnagramsI(String[] strs) {
        if (strs.length == 0){
            return new ArrayList();
        }
        
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        
        for(String s : strs){
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++){
                sb.append('#');
                sb.append(count[i]);
            }
            
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            
            ans.get(key).add(s);
        }
        
        return new ArrayList(ans.values());
    }

}
