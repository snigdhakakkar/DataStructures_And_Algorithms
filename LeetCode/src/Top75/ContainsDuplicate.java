package Top75;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	
	 public boolean containsDuplicate(int[] nums) {
	        Set<Integer> match = new HashSet<>();
	        for(int x: nums){
	            if(match.contains(x))
	            {
	                return true;
	            }
	            match.add(x);
	        }
	        return false;
	}

}
