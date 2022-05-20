package Top75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem statement - Find all valid combinations of k numbers that sum up to n such that 
 * the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, 
and the combinations may be returned in any order.
 */

public class combination_sum_III {
	
	public List<List<Integer>> combinationSum3(int k, int n) {
        //approach 1: backtracking
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        
        
        this.backtrack(n, k, comb, 0, results);
        return results;
    }
    
    protected void backtrack(int remain,
                            int k, LinkedList<Integer> comb, int next_start,
            List<List<Integer>> results) {
        if (remain == 0 && comb.size() == k) {
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0 || comb.size() == k) {
            // Exceed the scope, no need to explore further.
            return;
        }
        
        for (int i = next_start; i < 9; ++i){
            comb.add(i + 1);
            this.backtrack(remain - i - 1, k, comb, i + 1, results);
            comb.removeLast();
        }
        
        //time complexity: O(9!K/(9- K)!) ; space complexity: O(K)
        
    }

}
