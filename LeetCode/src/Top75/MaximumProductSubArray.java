package Top75;

public class MaximumProductSubArray {
	
	public int maxProduct(int[] nums) {
        //naive approach - go through each element in nums
		//time complexity: O(N^2); Space complexity: O(1)
		
        if (nums.length == 0){
            return 0;   
        }
        
        int result = nums[0];
        
        for(int i = 0; i < nums.length; i++){
            int product = 1;
            for(int j = i; j < nums.length; j++){
                product *= nums[j];
                result = Math.max(result, product);
            }
        }
        
        return result;
    }
    
    
	
	public int maxProduct1(int[] nums) {
        //Dynamic Programming - need to handle zeroes and negative numbers
        
        /*Zeros will reset the combo chain. A high score which once has been achieved will be recorded in placeholder result. 
         * One will have to restart the combo chain after zero. If one encounters another combo chain which is higher than the recorded high score in result, 
         * one just need to update the result.
        
        //A single negative number can flip the largest combo chain to a very small number. 
         * This may sound like the combo chain has been completely disrupted but if one encounters another negative number, the combo chain can be saved. 
        
        //While going through numbers in nums, we will have to keep track of the maximum product up to that number 
         * (we will call max_so_far) and minimum product up to that number (we will call min_so_far).
        
        //max_so_far is updated by taking the maximum value among: 
         * Current number (if the accumulated product has been really bad (even compared to the current number) e.g. [0,5] or [-3,4]) , 
         * Product of last max_so_far & current number (if the accumulated product has been steadily increasing (all positive numbers)) , 
         * Product of last min_so_far and current number (if the current number is a negative number and the combo chain has been disrupted by a single negative number before)
        
        //min_so_far is updated in using the same three numbers except that we are taking minimum among the above three numbers 
		
		*/
		
		//time complexity: O(N); Space complexity: O(1)
        
        if (nums.length == 0){
            return 0;
        }
        
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;
        
        for (int i = 1; i < nums.length; i++){
             int curr = nums[i];
             int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
             min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));
            
            max_so_far = temp_max;
            
            result = Math.max(max_so_far, result);
        }
        
        return result;
    }
	
	
    
    
	
	

}
