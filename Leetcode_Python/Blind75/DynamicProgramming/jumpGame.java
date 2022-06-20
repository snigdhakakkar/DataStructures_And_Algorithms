//DP Top-down approach
enum Index {
    GOOD, BAD, UNKNOWN
}
class Solution {
    
    Index[] memo;
    
    public boolean canJump(int[] nums) {
        
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++){
            memo[i] = Index.UNKNOWN;
        }
        
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
        
    }
    
    public boolean canJumpFromPosition(int position, int[] nums){
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }
        
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++){
            if (canJumpFromPosition(nextPosition, nums)){
                memo[position] = Index.GOOD;
                return true;
            }
        }
        
        memo[position] = Index.BAD;
        return false;
    }
}

/*
 * Time complexity: O(n^2) as For every element i, we are looking at the next nums[i] elements 
 * to its right aiming to find a GOOD index. nums[i] can be at most nn, where nn is the length of array nums.
 * 
 * Space complexity: O(2n) = O(n) . First n originates from recursion. 
 * Second n comes from the usage of the memo table.
 */