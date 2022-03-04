package BasicCodingProblems;

public class isPalindrome {
	//time complexity: O(N) where N is the number of digits
	public static void main(String[] args) {
		isPalindrome a = new isPalindrome();
		System.out.println(a.checkIfPalindrome(12321));
		System.out.println(a.checkIfPalindrome(123));
	}
	    
	public boolean checkIfPalindrome(int n) {
		int s = 0;
		int t = n;
		
		while(t > 0) {
			s = s * 10 + t % 10;
			t = t / 10;
		}
		
		return s == n;
	}

}
