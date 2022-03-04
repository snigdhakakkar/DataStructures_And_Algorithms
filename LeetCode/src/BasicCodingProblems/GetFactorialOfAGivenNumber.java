package BasicCodingProblems;

public class GetFactorialOfAGivenNumber {
	
	//using recursion
	public int fact(int n) {
		if(n == 1) {
			return 1;
		}
		
		return n * fact(n - 1);
	}
	
	//without using recursion
	public int factorial(int n) {
		int fac = 1;
		
		for(int i = 1; i <= n; i++) {
			fac = fac * i;
		}
		
		return fac;
	}
	
	public static void main(String[] args) {
		
		GetFactorialOfAGivenNumber a = new GetFactorialOfAGivenNumber();
		System.out.println(a.fact(6));
		System.out.println(a.factorial(6));
	}

}
