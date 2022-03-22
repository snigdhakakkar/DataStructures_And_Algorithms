package DynamicProgrammingProblems;

//three operations allowed: add, remove, modify
//b --> ba (we can add a in second string)
//ba --> b ( we can remove a in s1)
//ba --> bu ( we can modify a to u to convert from s1 to s2)
//bat --> but ( we can modify a to u to convert from s1 to s2)
//bat --> beau (modify t to u; add e in s1)
//ba --> ba (don't need any operations)

public class EditDistanceFromS1ToS2 {
	
	public static void main(String[] args) {
		EditDistanceFromS1ToS2 a = new EditDistanceFromS1ToS2();
		String s1 = "bate";
		String s2 = "bau";
		
		System.out.println(a.editDistance(s1, s2));
		
		System.out.println(a.editDistanceBottomUp(s1, s2, s1.length(), s2.length()));
	}
	
	//recursion
	//time complexity: O(3^(l1+l2))
	
	public int editDistance(String s1, String s2) {
		if(s1 == s2) {
			return 0;
		}
		
		return editDistanceImp(s1, s2, s1.length(), s2.length());
	}
	
	public int editDistanceImp(String s1, String s2, int l1, int l2) {
		if(l1 == 0) {
			return l2;
		}
		
		if(l2 == 0) {
			return l1;
		}
		
		if(s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
			return editDistanceImp(s1, s2, l1 - 1, l2 - 1);
		}
		
		return 1 + Math.min(Math.min(editDistanceImp(s1, s2, l1 - 1, l2 - 1), editDistanceImp(s1, s2, l1, l2 - 1)), editDistanceImp(s1, s2, l1 - 1, l2));
	}
	
	//DP Bottom Up Approach
	//time complexity: O(l1*l2)
	//space complexity: O(l1*l2)
	public int editDistanceBottomUp(String s1, String s2, int l1, int l2) {
		if(s1 == s2) {
			return 0;
		}
		
		if(l1 == 0) {
			return l2;
		}
		
		if(l2 == 0) {
			return l1;
		}
		
		int[][] arr = new int[l1 + 1][l2 + 1];
		
		for(int i = 0; i < l1; i++) {
			arr[0][i] = i;
		}
		
		for(int i = 0; i < l2; i++) {
			arr[i][0] = i;
		}
		
		for(int i = 1; i <= l1; i++) {
			for(int j = 1; j <= l2; j++) {
				
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1];
				} else {
					arr[i][j] = 1 + Math.min(arr[i - 1][j - 1], Math.min(arr[i][j - 1], arr[i - 1][j]));
				}
			}
		}
		
		return arr[l1][l2];
		
	}

}
