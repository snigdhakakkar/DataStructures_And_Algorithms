package DynamicProgrammingProblems;

public class LongestPalindromeSequence {
	
	public static void main(String[] args) {
		LongestPalindromeSequence a = new LongestPalindromeSequence();
		
		String str = "abeebac";
		
		System.out.println(a.lps(str, 0, str.length() - 1));
		
		Integer[][] arr = new Integer[str.length()][str.length()];
		
		System.out.println(a.lpsTopDown(str, 0, str.length() - 1, arr));
		
		System.out.println(a.lpsBottomUp(str, str.length()));
	}
	//recursion
	//time complexity: O(2^n)
	//space complexity: O(n)  
	
	public int lps(String str, int start, int end) {
		if(start > end) {
			return 0;
		}
		
		if(start == end) {
			return 1;
		}
		
		if(str.charAt(start) == str.charAt(end)) {
			return 2 + lps(str, start + 1, end - 1);
		}
		
		return Math.max(lps(str, start + 1, end), lps(str, start, end - 1));
	}
	
	//DP Top Down Approach
	//time complexity: O(n^2)
	//space complexity: O(n^2)
	
	public int lpsTopDown(String str, int start, int end, Integer[][] arr) {
		if(start > end) {
			return 0;
		}
		
		if(start == end) {
			return 1;
		}
		   
		if(arr[start][end] == null) {
			if(str.charAt(start) == str.charAt(end)) {
				arr[start][end] = 2 + lpsTopDown(str, start + 1, end - 1, arr);
			} else {
				arr[start][end] = Math.max(lpsTopDown(str, start + 1, end, arr), lpsTopDown(str, start, end - 1, arr));
			}
		}     
		
		return arr[start][end];
	}
	
	//DP Bottom Up Approach
	//time complexity: O(l^2)
	//space complexity: O(l^2)
	public int lpsBottomUp(String str, int l) {
		int[][] arr = new int[l][l];
		
		for(int i = l - 2; i >= 0; i--) {
			for(int j = i + 1; j < l; j++) {
				
				if(str.charAt(i) == str.charAt(j)) {
					arr[i][j] = 2 + arr[i + 1][j - 1];
				} else {
					arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);
				}
			}
		}
		
		return arr[0][l - 1];
	}

}
