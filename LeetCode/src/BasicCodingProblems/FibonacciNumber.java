package BasicCodingProblems;

public class FibonacciNumber {
	
	public int getFibonacciNumber(int n) {
		if(n <= 1) {
			return n;
		}
		
		return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
	}
	
	public static void main(String[] args) {
		FibonacciNumber a = new FibonacciNumber();
		System.out.println(a.getFibonacciNumber(7));
	}

}
