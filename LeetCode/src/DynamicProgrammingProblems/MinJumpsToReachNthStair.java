package DynamicProgrammingProblems;

//Possible steps --> {1,2,3}
//1 + min(T(n - 1), T(n - 2), T(n - 3))
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


public class MinJumpsToReachNthStair {
	
	//recursive approach
	public int minSteps(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1 || n == 2 || n == 3) {
			return 1;
		}
		
		return 1 + Math.min(Math.min(minSteps(n - 1), minSteps(n - 2)), minSteps(n - 3));
	}
	
	//TOP-DOWN Approach
	public int minStepsTopDown(int[] arr, int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1 || n == 2 || n == 3) {
			return 1;
		}
		
		if(arr[n] == 0) {
			arr[n] = 1 + Math.min(Math.min(minStepsTopDown(arr, n - 1), minStepsTopDown(arr, n - 2)), minStepsTopDown(arr, n - 3));
		}
		
		return arr[n];
	}
	
	//BOTTOM - UP Approach
	public int minStepsBottomUp(int n) {
		int[] f = new int[n + 1];
		
		f[0] = 0;
		f[1] = 1;
		f[2] = 1;
		
		for(int i = 3; i <= n; i++) {
			f[i] = 1 + Math.min(Math.min(f[i - 1], f[i - 2]), f[i - 3]);
		}
		
		return f[n];
	}
	
	//BOTTOM - UP Better Approach
	public int minStepsBottomUpBetter(int n) {
		int a = 0;
		int b = 1;
		int c = 1;
		int d;
		
		for(int i = 3; i <= n; i++) {
			d = 1 + Math.min(Math.min(a, b), c);
			
			a = b;
			b = c;
			c = d;
		}
		
		return c;
		
	}
	
	//main method
	public static void main(String[] args) {
		MinJumpsToReachNthStair a = new MinJumpsToReachNthStair();
		
		int n = 10;
		System.out.println(a.minSteps(n));
		
		int[] arr = new int[n + 1];
		System.out.println(a.minStepsTopDown(arr, n));
		
		System.out.println(a.minStepsBottomUp(n));
		System.out.println(a.minStepsBottomUpBetter(n));
		
	}
	
}
