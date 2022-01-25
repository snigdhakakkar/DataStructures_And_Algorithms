package array;

public class LargestContiguousSumSubArray {
	
	public static void main(String[] args) {
		
		int arr[] = {12, -8, 30, -6, 15, -2, 1, -18 };
		
		
		LargestContiguousSumSubArray l = new LargestContiguousSumSubArray();
		
		System.out.println(l.largestContiguousSumSubArray(arr));
		
		l.largestContiguousSumSubArrayWithIndices(arr);
	}
	
	public int largestContiguousSumSubArray(int[] arr) {
		int max_so_far, current_max;
		max_so_far = current_max = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			current_max = Math.max(arr[i], current_max + arr[i]);
			max_so_far = Math.max(current_max, max_so_far);
		}
		
		return max_so_far;
	}
	
	public void largestContiguousSumSubArrayWithIndices(int[] arr) {
		int max_so_far, current_max;
		max_so_far = current_max = arr[0];
		int start, end, s;
		start = end = s = 0;
		
		for(int i = 1; i < arr.length; i++) {
			
			if(arr[i] > current_max + arr[i]) {
				current_max = arr[i];
				s = i;
			} else {
				current_max =  current_max + arr[i];
			}
			
			if(current_max > max_so_far) {
				max_so_far = current_max;
				start = s;
				end = i;
			}
		}
		
		System.out.println("Max: " + max_so_far);
		System.out.println("Indices from " + start + " to " + end);
	}

}
