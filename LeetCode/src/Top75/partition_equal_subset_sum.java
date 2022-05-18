package Top75;
/*
 * Problem statement  - Given a non-empty array nums containing only positive integers, 
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 */
public class partition_equal_subset_sum {
	
	 public boolean canPartition(int[] nums) {
	        //Approach 1 : Recursion, time complexity: O(2^n) and space complexity: O(n)
	        /* we can either choose an element or not
	        */
	        int sum = 0;
	        //calculate sum
	        for (int num : nums) {
	            sum += num;
	        }
	        if (sum % 2 != 0) { 
	        return false;}
	        
	        return recursion(nums, 0, sum/2);
	        //recursively checking whether there exists a subset with target sum or not
	    }
	    
	 private boolean recursion(int[] nums, int index, int sum) {
	        //base cases
	        if(sum == 0) { 
	        return true;
	        }
	        if (sum < 0 || index == nums.length) {
	            return false;
	        }
	        
	        return recursion(nums, index + 1, sum - nums[index]) || recursion(nums, index + 1, sum);
	        //either choose nums[index] or not
	    }
	    
	    private Boolean[][] memo; //use memo to store the result of subproblems
	    
	    public boolean canPartitionI(int[] nums) {
	        
	         //Approach 2: DP - Recursion with memoization approach
	        // we divide the original problem into several sub problems and save same sub problems (memo)
	        //time complexity: O(mn), space complexity: O(mn) where m is the half of the sum of input array
	        
	        int sum = 0;
	        for(int num : nums) {
	            sum += num;
	        }
	        if (sum % 2 != 0) {
	            return false;
	        }
	        
	        sum /= 2;
	        memo = new Boolean[nums.length + 1][sum + 1];
	        return recursion(nums, 0, sum);
	    }
	    
	    private boolean recursionI(int[] nums, int index, int sum){
	        if(sum == 0){
	            return true;
	        }
	        
	        if (sum < 0 || index == nums.length) {
	            return false;
	        }
	        
	        if (memo[index][sum] != null) {
	            return memo[index][sum];
	        }
	        
	        boolean res = recursion(nums, index + 1, sum - nums[index]) || recursion(nums, index + 1, sum);
	        memo[index][sum] = res;
	        return res;
	    }
	    
	    public boolean canPartitionII(int[] nums) {
	        // problem has Overlapping Subproblem property and can be solved using Dynamic Programming.
	         //Approach 3: DP  approach - bottom up approach
	        
	        //time complexity: O(m.n) where m is the subsetsum and n is the number of array elements; space complexity: O(mn)
	        
	        int totalSum = 0;
	        //find the sum of all the array elements
	        for (int num : nums) {
	            totalSum += num;
	        }
	        
	        //if totalSum is odd, it cannot be partitioned into equal sum subset
	        if (totalSum % 2 != 0 ){
	            return false;
	        }
	        
	        int subSetSum = totalSum / 2;
	        int n = nums.length;
	        boolean dp[][] = new boolean[n + 1][subSetSum + 1];
	        dp[0][0] = true;
	        for (int i = 1; i <= n; i++) {
	            int curr = nums[i - 1];
	            for (int j = 0; j <= subSetSum; j++){
	                if (j < curr){
	                    dp[i][j] = dp[i - 1][j];
	                } else {
	                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - curr]);
	                }
	            }
	        }
	        
	        return dp[n][subSetSum];
	        
	       
	    }

}
