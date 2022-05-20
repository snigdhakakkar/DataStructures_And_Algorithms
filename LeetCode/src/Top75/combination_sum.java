package Top75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem statement - 
Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.It is guaranteed that the number of unique combinations that sum up to target 
is less than 150 combinations for the given input.
 */

public class combination_sum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //approach 1: backtracking
        //the execution of backtracking is unfolded as a DFS traversal in a n-ary tree.
        /* Complexity Analysis: Let N be the number of candidates, T be the target value, and 
          M be the minimal value among the candidates.
          Time complexity: O(N^(T/M + 1)) where T/M would be the max depth of the tree, where we keep on adding the smallest element to the combination
          
          Space complexity = O(T/M)
        */
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        
        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }
    
    protected void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates, 
                            List<List<Integer>> results) {
        
        if (remain == 0) {
            //make a deep copy of the current combination
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            //exceeded the scope, stop exploration
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            //add the number into the combination
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            
            //backtrack, remove the number from the combination
            comb.removeLast();
        }
        
        
    }

}
