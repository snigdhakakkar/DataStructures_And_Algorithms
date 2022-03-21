package DynamicProgrammingProblems;

//s1 = abde
//s2 = acbef
//longest common subsequence: abe

public class LongestCommonSubsequence {
	
	//recursion
	//time complexity: O(n^2) as we are doing two recursions in parallel
	public int lcs(String s1, String s2, int l1, int l2) {
		if(l1 == 0 || l2 == 0) {
			return 0;
		}
		
		if(s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
			return 1 + lcs(s1, s2, l1 - 1, l2 - 1);
		}
		
		return Math.max(lcs(s1, s2, l1 - 1, l2), lcs(s1, s2, l1, l2 -1));
	}
	
	//TOP-DOWN Approach
	
	// time complexity: O(l1 * l2);
	//space complexity: O(l1 * l2);
	public int lcsTopDown(String s1, String s2, int l1, int l2, Integer[][] arr) {
		if(l1 == 0 || l2 == 0) {
			return 0;
		}
		
		if(arr[l1][l2] == null) {
			if(s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
				arr[l1][l2] = 1 + lcsTopDown(s1, s2, l1 - 1, l2 - 1, arr);
			} else {
				arr[l1][l2] = Math.max(lcsTopDown(s1, s2, l1 - 1, l2, arr), lcsTopDown(s1, s2, l1, l2 -1, arr));
			}
		}
		
		return arr[l1][l2];
		
	}
	
	//BOTTOM-UP Approach
	
	// time complexity: O(l1 * l2);
	//space complexity: O(l1 * l2);
	public int lcsBottomUp(String s1, String s2, int l1, int l2) {
		if(l1 == 0 || l2 == 0) {
			return 0;
		}
		
		int[][] arr = new int[l1 + 1][l2 + 1];
		
		for(int i = 1; i <= l1; i++) {
			for(int j = 1; j <= l2; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					arr[i][j] = 1 + arr[i - 1][j - 1];
				} else {
					arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
				}
			}
		}
		
		return arr[l1][l2];
	}
	
	public static void main(String[] args) {
		
		LongestCommonSubsequence a = new LongestCommonSubsequence();
		String s1 = "abde";
		String s2 = "acbef";
		
		System.out.println(a.lcs(s1, s2, s1.length(), s2.length()));
		
		Integer[][] arr = new Integer[s1.length() + 1][s2.length() + 1];
		System.out.println(a.lcsTopDown(s1, s2, s1.length(), s2.length(), arr));
		
		System.out.println(a.lcsBottomUp(s1, s2, s1.length(), s2.length()));
	}
}
