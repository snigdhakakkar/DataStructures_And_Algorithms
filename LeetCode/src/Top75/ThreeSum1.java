package Top75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem statement - Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */

//Two pointer approach\

public class ThreeSum1 {
	
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length  && nums[i] <= 0; ++i){
            if (i == 0 || nums[i - 1] != nums[i]){
                twoSumII(nums, i, res);
            }
        }
        
        return res;
    }
    
    public static void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1]){
                    ++lo;
                }
            }
        }
    }
    
    //time complexity: O(N^2) as tiem complexity of twoSumII is O(N) and we call it almost N times
    //Sorting takes O(NlogN), so overall complexity: O(NlogN) + O(N^2) ~= O(N^2)
    //Space complexity:O(logN) to O(N) depending upon the sorting algorithm being used.
	
	   

}
