package DynamicProgrammingProblems;

//F(n) = F(n - 1) + F(n - 2): 1, 1, 2, 3, 5, 8, ....

//Properties where DP is applied: Overlapping problems and optimal sub-structure
//Top-down approach and bottom-up approach
//memoization: storing the value in the memory

//Time complexity: O(2^n) when we were doing recursion and O(N) when we use DP
//Space complexity: O(N)
public class GetFibonacciNumber {
	
	//RECURSIVE APPROACH
	public int getFibonacciNumber(int n) {
		if(n <= 1) {
			return n;
		}
		
		return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
	}
	
	//TOP-DOWN APPROACH
	public int getFibonacciTopDown(int[] arr, int n) {
		if(n < 2) {
			return n;
		}
		
		if(arr[n] == 0) {
			arr[n] = getFibonacciTopDown(arr, n - 1) + getFibonacciTopDown(arr, n - 2);
		}
		
		return arr[n];
	}
	
	//BOTTOM-UP APPROACH
	public int getFibonacciBottomUp(int n) {
		int[] f = new int[n + 1];
		
		f[0] = 0;
		f[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		
		return f[n];
	}
	
	public int getFibonacciBottomUpBetter(int n) {
		int a = 0;
		int b = 1;
		int c;
		
		for(int i = 2; i <= n; i++) {
			c = a + b;
			
			a = b;
			b = c;
		}
		
		return b;
		
	}
	
	//BOTTOM-UP APPRACH - BETTER VERSION TO REDUCE SPACE COMPLEXITY
	
	
	public static void main(String[] args) {
		GetFibonacciNumber a = new GetFibonacciNumber();
		int n = 5;
		System.out.println(a.getFibonacciNumber(n));
		
		int[] arr = new int[n + 1];
		System.out.println(a.getFibonacciTopDown(arr, n));
		
		
		System.out.println(a.getFibonacciBottomUp(n));
		
		System.out.println(a.getFibonacciBottomUpBetter(n));
		
	}
	
	
	

}
