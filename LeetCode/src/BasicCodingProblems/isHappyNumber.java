package BasicCodingProblems;

public class isHappyNumber {
	//happy number - sum of square of digits finally leads to 1
	// 19 --> 82 --> 68 --> 100 --> 1
	public static void main(String[] args) {
		isHappyNumber a = new isHappyNumber();
		System.out.println(a.checkIfHappyNumber(19));
		System.out.println(a.checkIfHappyNumber(25));
	}
	
	public boolean checkIfHappyNumber(int n) {
		int slow, fast;
		slow = fast = n;
		
		do {
			slow = getNextValue(slow);
			fast = getNextValue(getNextValue(fast));
		} while (slow != fast);
		
		return slow == 1;
	}
	
	private int getNextValue(int val) {
		int square = 0;
		
		while(val > 0) {   
			int t = val % 10; //5 //2
			square = square + t * t;
			val = val / 10; //25/10 = 2
		}
		
		return square;
	}

}
