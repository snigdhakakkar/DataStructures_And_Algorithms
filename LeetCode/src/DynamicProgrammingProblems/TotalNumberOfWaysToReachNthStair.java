package DynamicProgrammingProblems;
//Steps --> {1,2,3}
//n = 0 , noOfway = 1
//n = 1, noOfway = 1
//n = 2, noOfway = 2 --> {1,2}
//n = 3, noOfway = 4 --> {(1,1,1), (1,2), (2,1),(3)}
//T(3) = T(2) + T(1) + T(0) = T(3 - 1) + T(3 - 2) + T(3 - 3)
//T(n) = T(n - 1) + T(n - 2) + T(n - 3)
//T(4) = T(3) + T(2) + T(1) 

//time complexity: O(3^n) as we are doing 3 recursion calls in parallel
//space complexity: O(n) as system stack is used in recursion

//Conditions to apply DP:
//Overlapping problems
//Optimal substructure

//Time complexity using top-down DP: O(n)
//Space complexity: O(n) as we have used an array

//Bottom-up DP solution --> always start from the bottom conditions
//Time complexity: O(n)
//Space complexity: O(n) as we have used an array

//Better approach: instead of array, use variables to store values


public class TotalNumberOfWaysToReachNthStair {
	
	//Recursive approach
	public int totalNumberOfWaysToReachNthStair(int n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		
		return totalNumberOfWaysToReachNthStair(n - 1) + totalNumberOfWaysToReachNthStair(n - 2) 
		+ totalNumberOfWaysToReachNthStair(n - 3);
	}
	
	//TOP-DOWN approach
	public int totalNumberOfWaysToReachNthStairTopDown(int[] arr, int n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		
		if(arr[n] == 0) {
			arr[n] = totalNumberOfWaysToReachNthStairTopDown(arr, n - 1) 
					+ totalNumberOfWaysToReachNthStairTopDown(arr, n - 2)
					+ totalNumberOfWaysToReachNthStairTopDown(arr, n - 3);
		}
		
		return arr[n];
	}
	
	//BOTTOM-UP approach
	public int totalNumberOfWaysToReachNthStairBottomUp(int n) {
		int[] f = new int[n + 1];
		
		f[0] = 1;
		f[1] = 1;
		f[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2] + f[i - 3];
		}
		
		return f[n];
		
	}
	
	//BOTTOM-UP Better approach to improve space complexity
	public int totalNumberOfWaysToReachNthStairBottomUpBetter(int n) {
		int a = 1;
		int b = 1;
		int c = 2;
		int d;
		
		for(int i = 3; i <=n; i++) {
			d = a + b + c;
			
			a = b;
			b = c;
			c = d;
		}
		
		return c;
	}
	
	//Main Function
	public static void main(String[] args) {
		TotalNumberOfWaysToReachNthStair a = new TotalNumberOfWaysToReachNthStair();
		int n = 5;
		System.out.println(a.totalNumberOfWaysToReachNthStair(n));
		
		int[] arr = new int[n + 1];
		System.out.println(a.totalNumberOfWaysToReachNthStairTopDown(arr, n));
		
		System.out.println(a.totalNumberOfWaysToReachNthStairBottomUp(n));
		
		System.out.println(a.totalNumberOfWaysToReachNthStairBottomUpBetter(n));
	}

}
