package Top75;

/*
 * Problem statement - Given an integer array nums, return an array answer such that answer[i] is equal
 *  to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Follow up: Can you solve the problem in O(1) extra space complexity? 
(The output array does not count as extra space for space complexity analysis.)
 */
public class Product_of_array_except_Self {
	
	public int[] productExceptSelf(int[] nums) {
        //division approach is not allowed as per the question and it will also not work if any one array element is 0
        //we can use prefix array and suffix array and then multiply each element from the two arrays to get the answer array
        
        //for follow up question, instead of using left and right array, we can make use of integer variable and answer array
           
        int length = nums.length;
        int[] answer = new int[length];
        
        int[] left = new int[length];
        int[] right = new int[length];
        
        left[0] = 1;
        for(int i = 1; i < length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        right[length - 1] = 1;
        for(int i = length - 2; i >= 0; i--){
            right[i] = right[i + 1]* nums[i+1];
        }
        
        for(int i = 0; i < length; i++){
            answer[i] = left[i] * right[i];
        }
        
        return answer;
        
        //time complexity: O(n)
        //space complexity: O(n)
    }
	
	public int[] productExceptSelf1(int[] nums) {
        //division approach is not allowed as per the question and it will also not work if any one array element is 0
        //we can use prefix array and suffix array and then multiply each element from the two arrays to get the answer array
        
        //for follow up question, instead of using left and right array, we can make use of integer variable and answer array
        
        int length = nums.length;
        int[] answer = new int[length];
        
        answer[0] = 1;
        for(int i = 1; i < length; i++){
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        int right = 1;
        for(int i = length - 1; i >= 0; i--){
            answer[i] = answer[i]* right;
            right *= nums[i];
        }
        
        return answer;
        
        //time complexity: O(n)
        //space complexity: O(1)
    }
	
	

}
