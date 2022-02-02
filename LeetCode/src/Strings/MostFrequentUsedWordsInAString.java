package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MostFrequentUsedWordsInAString {
	
	public static void main(String[] args) {
		String str = "Best dessert to eat is rice pudding. Dessert is something I really love to eat. Dessert! #eat";
		MostFrequentUsedWordsInAString a = new MostFrequentUsedWordsInAString();
		
		System.out.println(a.mostFrequentwords(str));
	}
	
	//most frequent word
	//print all the most frequent words having highest and equal frequency
	//alphabetically
	
	//Remove all the symbols and special characters - replace with space
	//Convert string  to string array
	//Count map - tree map
	
	public List<String> mostFrequentwords(String str) {
		str = str.replaceAll("^a-zA-Z0-9", " ");
		String[] words = str.split(" +");
		
		Map<String, Integer> countMap = new HashMap<>();
		
		for(String word : words) {
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
		
		List<String> mostFrequentWords = new ArrayList<>();
		
		int topFreq = mostFrequentMap.firstEntry().getValue();
		
		while(!mostFrequentMap.isEmpty()) {
			Map.Entry<String, Integer> word = mostFrequentMap.pollFirstEntry();
			
			if(word.getValue() == topFreq) {
				mostFrequentWords.add(word.getKey());
			} else {
				break;
			}
		}
		
		return mostFrequentWords;
	}

}
