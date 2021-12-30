package array;

public class FindMaxConsecutiveOnes {
	static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0; //initializing the count to zero
        int max = 0; //initializing the maximum consecutive ones result to zero
        
        for (int i = 0; i < nums.length; i++) {
            
            //reset the count if number 0 is found
            if (nums[i] == 0) {
                count = 0;
            } else {
                count++; //incrementing the count if the number is 1
                max = Math.max(max, count);
            }
        }
        
        return max;
        
    }
    
    //Driver method
    public static void main(String[] args){
        int nums1[] = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums1));
    }

}
