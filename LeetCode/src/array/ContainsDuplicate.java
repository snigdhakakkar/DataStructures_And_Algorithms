package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	static boolean containsDuplicate(int[] nums) {
        Set<Integer> match = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!match.add(nums[i]))
            {
                return true;
            }
        }
        return false;
        }
	
	//Driver method
    public static void main(String[] args){
        int nums1[] = {1,2,3,4};
        System.out.println(containsDuplicate(nums1));
    }

}
