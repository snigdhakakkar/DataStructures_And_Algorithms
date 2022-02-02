package Strings;

/* Convert other characters to space
 * Split string into words
 * Count frequency of each word
 * Remove excluded words
 * Sort map as per frequency & alphabetically
 * put all the maximum frequency words in an arrayList
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GetMostFrequentWordAfterExcludingGivenWords {
	
	public static void main(String[] args) {
		String str = "Best dessert to eat is rice pudding. Dessert is something I really love to eat. Dessert! eat";
		
		String[] excluded_words = {"to", "is"};
		
		
		GetMostFrequentWordAfterExcludingGivenWords a = new GetMostFrequentWordAfterExcludingGivenWords();
		
		System.out.println(a.mostFrequentwordsAfterExcludingGivenWords(str, excluded_words));
	}
	
	public List<String> mostFrequentwordsAfterExcludingGivenWords(String str, String[] excluded_words){
		
		str = str.replaceAll("^a-zA-Z0-9", " ");
		String[] allWords = str.split(" +");
		
		Map<String, Integer> countMap = new HashMap<>();
		
		for(String word : allWords) {
			word = word.toLowerCase();
			countMap.put(word, countMap.getOrDefault(word, 0) + 1);
		}
		
		for(String excluded : excluded_words) {
			if(countMap.containsKey(excluded)) {
				countMap.remove(excluded);
			}
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
