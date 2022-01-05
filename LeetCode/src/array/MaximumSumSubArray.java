package array;

public class MaximumSumSubArray {
	static int maxSubArray(int[] nums) {
        
        return calculator(nums, 0, nums.length-1);
        
    }
	
	//Driver method
    public static void main(String[] args){
        int nums1[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums1));
    }
    
    static int calculator(int[] nums, int i, int j){
        
        //considering edge case 
        if(i==j){
            return nums[i];
        }
        
        int mid = (i+j)/2;
        int sum = 0;
        int leftMax = Integer.MIN_VALUE;
        
        for(int left=mid; left>=i; left--){
            sum += nums[left];
            if(sum > leftMax){
                leftMax = sum;
            }
            
        }
        
        int rightMax = Integer.MIN_VALUE;
        sum = 0; //resetting sum value to 0
        
         for(int right=mid+1; right<=j; right++){
            sum += nums[right];
            if(sum > rightMax){
                rightMax = sum;
            }
            
        }
        
        int maxLeftRight = Math.max(calculator(nums, i, mid), calculator(nums, mid+1, j));
        return Math.max(maxLeftRight, leftMax+rightMax);     
        
    }
}


