/*Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.*/

//Approach 1: Using Separate Space
class Solution {
    public int[] runningSum(int[] nums) {
        int[] output = new int[nums.length];
        
        //initialize the first element of the output array with the first element from the nums
        output[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            //result at index i is sum of result at index i-1 and element at index i
            output[i] = output[i - 1] + nums[i]; 
        }
        
        return output;
        
    }
}

