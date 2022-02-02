package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Four cases:
 * Case 1: Random order
 * Case 2: Decreasing frequency-wise
 * Case 3: Alphabetically
 * Case 4: Decreasing frequency + alphabetically
 */
public class GetFrequencyOfEveryWord {
	
	public static void main(String[] args) {
		String str = "Best dessert to eat is rice pudding. Dessert is something I really love to eat. Dessert! eat";
		
		GetFrequencyOfEveryWord a = new GetFrequencyOfEveryWord();
		System.out.println(a.getFrequencyOfAllWords(str));
		
	}
	
	public Map<String, Integer> getFrequencyOfAllWords(String str){
		
		str = str.replaceAll("[^a-zA-Z0-9]", " ");
		String[] allWords = str.split(" +");
		
		Map<String, Integer> countMap = new HashMap<>();
		
		for(String word : allWords) {
			word = word.toLowerCase();
			countMap.put(word, countMap.getOrDefault(word, 0) + 1);
		}
		
		TreeMap<String, Integer> mostFrequentMap = new TreeMap<>((e1, e2) -> {
			int freq1 = countMap.get(e1);
			int freq2 = countMap.get(e2);
			
			if(freq1 != freq2) {
				return freq2 - freq1;
			}
			
			return e1.compareTo(e2);
		});
		
		mostFrequentMap.putAll(countMap);
		
		return mostFrequentMap;
	}
	
	

}
