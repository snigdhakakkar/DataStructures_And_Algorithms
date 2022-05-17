package Top75;

/*
 * Problem statement - You are given an integer array height of length n. There are n vertical lines drawn such that 
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
 */

public class ContainerWithMostWater {
	
	//Non-optimal naive solution
	/*
	 * We have to maximize the Area that can be formed between the vertical lines using the shorter line 
	 * as length and the distance between the lines as the width of the rectangle forming the area.
	 * 
	 * Time complexity: O(n^2) and space complexity: O(1)
	 */
	
	public int maxArea(int[] height) {
		//1. Initialize max to zero
		int max = 0;
		
		//2. A for loop for left pointer
		for (int i = 0; i < height.length; i++) {
			//3. A for loop for right pointer
			for (int j = i + 1; j < height.length; j++) {
				int currentArea = Math.min(height[i],  height[j])*(j - i);
				//4. Update maximum area
				max = Math.max(max, currentArea);
			}
		}
		
		return max;
		//5. Return the maximum area
	}
	
	//Two pointer approach
	//ensure more width and more height for maxArea
	public int maxAreaI(int[] height) {
		//move the pointer corresponding to the lesser height and keep the other pointer intact
        
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int currentArea = Math.min(height[left], height[right])*(right - left);
            max = Math.max(max, currentArea);
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        
        return max;
	}
    
    //time complexity: O(N), space complexity: O(1)

}
