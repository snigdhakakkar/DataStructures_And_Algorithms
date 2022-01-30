package array;

public class LongestSubArrayWithAllOnesWhenWeCanReplaceOnlyKZeroes {
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 1, 0, 1, 1, 1, 0};
		int k = 2;
		
		LongestSubArrayWithAllOnesWhenWeCanReplaceOnlyKZeroes a = new LongestSubArrayWithAllOnesWhenWeCanReplaceOnlyKZeroes();
		
		System.out.println(a.findLongestSubArrayWithAllOnes(arr, k));
	}
	
	public int findLongestSubArrayWithAllOnes(int[] arr, int k) {
		if(arr == null || arr.length == 0 || k<= 0 || k>arr.length) {
			return -1;
		}
		
		int max_length = 0;
		int start = 0;
		int end = 0;
		int number_of_zeroes = 0;
		
		while(end < arr.length) {
			if(arr[end] == 0) {
				number_of_zeroes++;
			}
			
			if(number_of_zeroes > k) {
				if(arr[start] == 0) {
					number_of_zeroes--;
				}
				
				start++;
			}
			
			max_length = Math.max(max_length, end - start + 1);
			end++;
		}
		
		
		return max_length;
		
				
	}

}
