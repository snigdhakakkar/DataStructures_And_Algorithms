package Top75;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * Problem statement: Given an array of intervals 
 * where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the 
 * intervals in the input.
 */

public class merge_intervals {
	
	public int[][] merge(int[][] intervals) {
        
        //Approach 1: Sorting: time - O(NlogN); Space - O(N)
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        
        for (int[] interval : intervals) {
        // if the list of merged intervals is empty or if the current
        // interval does not overlap with the previous, simply append it.  
        if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
            merged.add(interval);
        }
            
         // otherwise, there is overlap, so we merge the current and previous
            // intervals.
        else {
            merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        
        }
        
        return merged.toArray(new int[merged.size()][]);
    }

}
