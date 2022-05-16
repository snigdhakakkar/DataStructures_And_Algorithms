package Top75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum2 {
	
	 public List<List<Integer>> threeSum1(int[] nums) {
	        Arrays.sort(nums);
	        
	        List<List<Integer>> res = new ArrayList<>();
	        for (int i = 0; i < nums.length  && nums[i] <= 0; i++){
	            if (nums[i - 1] != nums[i]){
	                twoSum(nums, i, res);
	            }
	        }
	        
	        return res;
	    }
	    
	    public static void twoSum(int[] nums, int i, List<List<Integer>> res) {
	        var seen = new HashSet<Integer>();
	        for (int j = i + 1; j < nums.length; ++j) {
	            int complement = - nums[i] - nums[j];
	            if (seen.contains(complement)) {
	                res.add(Arrays.asList(nums[i], nums[j], complement));
	                while(j + 1 < nums.length && nums[j] == nums[j + 1]){
	                    ++j;
	                }
	                seen.add(nums[j]);
	            }
	        }
	    }
	    
	    //time complexity: O(N^2) as tiem complexity of twoSum is O(N) and we call it almost N times
	    //Sorting takes O(NlogN), so overall complexity: O(NlogN) + O(N^2) ~= O(N^2)
	    //Space complexity:O(N) for the hashSet.

}
