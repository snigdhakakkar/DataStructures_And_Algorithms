package DynamicProgrammingProblems;

public class LongestPalindromeSubstring {
	
	public static void main(String[] args) {
		
		LongestPalindromeSubstring a = new LongestPalindromeSubstring();
		
		String str = "adada";
		
		System.out.println(a.lpsubstr(str, 0, str.length() - 1));
		
		Integer[][] arr = new Integer[str.length()][str.length()];
		
		System.out.println(a.lpsubstrTopDown(str, 0, str.length() - 1, arr));
		
		System.out.println(a.lpsubstrBottomUp(str, str.length()));
	}
	
	//recursion       
	//time complexity: O(2^n)
	//space complexity: O(n)
	
	public int lpsubstr(String str, int start, int end) {
		if(start > end) {
			return 0;
		}
		
		if(start == end) {
			return 1;
		}
		
		if(str.charAt(start) == str.charAt(end)) {
			int lpsRemainingString = end - start - 1;
			
			if(lpsRemainingString == lpsubstr(str, start + 1, end - 1)) {
				return 2 + lpsRemainingString;
			}
		}
		
		return Math.max(lpsubstr(str, start + 1, end), lpsubstr(str, start, end - 1));
	}
	
	//DP Top Down Approach
	//time complexity: O(n^2)
	//space complexity: O(n^2)
		
	public int lpsubstrTopDown(String str, int start, int end, Integer[][] arr) {
		if(start > end) {
			return 0;
		}
		
		if(start == end) {
			return 1;
		}
		
		if(arr[start][end] == null) {
			if(str.charAt(start) == str.charAt(end)) {
				int lpsRemainingString = end - start - 1;
				
				if(lpsRemainingString == lpsubstrTopDown(str, start + 1, end - 1, arr)) {
					arr[start][end] = 2 + lpsRemainingString;
				} 
			} else {
				arr[start][end] = Math.max(lpsubstrTopDown(str, start + 1, end, arr), lpsubstrTopDown(str, start, end - 1, arr));
			}
		}
		
		return arr[start][end];
		
	}
	
	//DP Bottom Up Approach
	//time complexity: O(l^2)
	//space complexity: O(l^2)
	
	public int lpsubstrBottomUp(String str, int l) {
		if(str == "") {
			return 0;
		}
		
		boolean[][] arr = new boolean[l][l];
		int maxlps = 1;
		
		for(int i = 0; i < str.length(); i++) {
			arr[i][i] = true;
		}
		
		for(int i = l - 2; i >= 0; i--) {
			for(int j = i + 1; j < l; j++) {
				
				if(str.charAt(i) == str.charAt(j)) {
					if(arr[i + 1][j - 1] || j - i == 1) {
						arr[i][j] = true;
						maxlps = Math.max(maxlps, j - i + 1);
					}
				}
			}
		}
		
		return maxlps;
		
	}
	
	

}
