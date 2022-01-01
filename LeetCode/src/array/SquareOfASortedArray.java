package array;
import static java.lang.Math.abs;

public class SquareOfASortedArray {
	static int[] sortedSquares(int[] nums) {
        int[] outcome = new int[nums.length];
        int left = 0;
        int right = outcome.length -1; //initializing the two pointers for min and max
        int pos = right;
        while(left<=right){
            if(Math.abs(nums[left]) >= Math.abs(nums[right])){
                outcome[pos] = nums[left]*nums[left];
                left += 1;
                pos -= 1;
            }
            else {
                outcome[pos] = nums[right]*nums[right];
                right -= 1;
                pos -=1;
            }
        }
        return outcome;
    }
	
public static void main(String[] args) {
	int arr[] = {-7,-3,2,3,11};
	int result[] = sortedSquares(arr);
	for(int n : result) {
		System.out.println(n);
	}
}

}
