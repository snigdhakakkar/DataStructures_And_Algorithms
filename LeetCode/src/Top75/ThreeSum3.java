package Top75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;


public class ThreeSum3 {
	
	public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        
        for(int i = 0; i < nums.length; ++i){
            if(dups.add(nums[i])) {
                for(int j = i + 1; j < nums.length; ++j){
                    int complement = -nums[i] - nums[j];
                    if(seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i); //hashmap will take care of removing the duplicates
                }
            }
            
            
        }
        
        return new ArrayList(res);
    }
    
    //time complexity: O(N^2) as we have outer and inner loops, each going through N elements.
    //Space complexity:O(N) for the hashSet.

}
