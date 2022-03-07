package BasicCodingProblems;

public class isArmstrongNumber {
	
	//Armstrong number: each digit multiplied by itself n times where n is the number of digits in the number; sum is the number itself
	// 153 = 1*1*1 + 5*5*5 + 3*3*3            
	
	public static void main(String[] args) {
		isArmstrongNumber a = new isArmstrongNumber();
		System.out.println(a.checkIfArmstrong(123));
		System.out.println(a.checkIfArmstrong(153));
	}
	
	public boolean checkIfArmstrong(int n) {
		int t = n;
		int order = 0; //number of digits in the number
		
		while(t > 0) {
			t = t / 10;
			order++;
		}
		
		t = n;
		int sum = 0;
		for(int i = 0; i < order; i++) {
			sum += Math.pow(t % 10, order);
			t = t / 10;
		}
		
		return sum == n;
		
		
	}

}
