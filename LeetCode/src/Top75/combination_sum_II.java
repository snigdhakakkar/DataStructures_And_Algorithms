package Top75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem statement - Given a collection of candidate numbers (candidates) and a target number (target), 
 
 * find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */

public class combination_sum_II {
	//BACKTRACKING WITH COUNTER APPROACH
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // container to hold the final combinations
		//time complexity: O(2^N); space complexity: O(N)
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int candidate : candidates) {
            if (counter.containsKey(candidate)){
                counter.put(candidate, counter.get(candidate) + 1);
            } else {
                counter.put(candidate, 1);
            }
        }
        
        // convert the counter table to a list of (num, count) tuples
        List<int[]> counterList = new ArrayList<>();
        counter.forEach((key, value) -> {
            counterList.add(new int[] {key, value});
        });
        
        backtrack(comb, target, 0, counterList, results);
        return results;
    }
    
    private void backtrack(LinkedList<Integer> comb,
                           int remain, int curr,
                           List<int[]> counter,
                           List<List<Integer>> results) {
        
        if (remain <= 0){
            if (remain == 0){
                // make a deep copy of the current combination.
                results.add(new ArrayList<Integer>(comb));
            }
            return;
        }
        
        for (int nextCurr = curr; nextCurr < counter.size(); ++nextCurr) {
            int[] entry = counter.get(nextCurr);
            Integer candidate = entry[0], freq = entry[1];
            
            if (freq <= 0)
                continue;
            
            // add a new element to the current combination
            comb.addLast(candidate);
            counter.set(nextCurr, new int[]{candidate, freq - 1});
            
            // continue the exploration with the updated combination
            backtrack(comb, remain - candidate, nextCurr, counter, results);
            
            // backtrack the changes, so that we can try another candidate
            counter.set(nextCurr, new int[]{candidate, freq});
            comb.removeLast();
        }
    }
    
    //BACKTRACKING WITH INDEX APPROACH
    public List<List<Integer>> combinationSum2I(int[] candidates, int target) {
        // container to hold the final combinations
    	//time complexity: O(2^N); space complexity: O(N)
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        
        Arrays.sort(candidates);
        
        backtrackI(candidates, comb, target, 0, results);
        return results;
    }
    
    private void backtrackI(int[] candidates, LinkedList<Integer> comb,
                           Integer remain, Integer curr,
                           List<List<Integer>> results){
        if (remain == 0){
            // copy the current combination to the final list.
            results.add(new ArrayList<Integer>(comb));
            return;
        }
        
        for (int nextCurr = curr; nextCurr < candidates.length; ++nextCurr){
            if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1]){
                continue;
            }
            
            Integer pick = candidates[nextCurr];
            // optimization: early stopping
            if (remain - pick < 0){
                break;
            }
            
            comb.addLast(pick);
            backtrackI(candidates, comb, remain - pick, nextCurr + 1, results);
            comb.removeLast();
        }
    }
	
	    

}
