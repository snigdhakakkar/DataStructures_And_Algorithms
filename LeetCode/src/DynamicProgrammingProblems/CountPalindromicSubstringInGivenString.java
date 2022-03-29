package DynamicProgrammingProblems;

public class CountPalindromicSubstringInGivenString {
	
	public static void main(String[] args) {
		
		CountPalindromicSubstringInGivenString a = new CountPalindromicSubstringInGivenString();
		
		String str = "bcacbf";
		
		System.out.println(a.numberOfPalindromicSubstring(str, str.length()));
		
	}
	   
	public int numberOfPalindromicSubstring(String str, int l) {
		
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		boolean[][] arr = new boolean[l][l];
		int count = str.length();
		
		for(int i = 0; i < str.length(); i++) {
			arr[i][i] = true;
		}
		
		for(int i = l - 2; i >= 0; i--) {
			for(int j = i + 1; j < l; j++) {
				
				if(str.charAt(i) == str.charAt(j)) {
					if(arr[i + 1][j - 1] || j - i == 1) {
						arr[i][j] = true;
						count++;
					}
				}
			}
		}
		
		return count;
		
	}

}
