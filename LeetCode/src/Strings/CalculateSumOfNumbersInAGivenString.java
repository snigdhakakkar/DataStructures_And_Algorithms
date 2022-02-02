package Strings;

public class CalculateSumOfNumbersInAGivenString {
	
	public static void main(String[] args) {
		String s = "65473";
		int i = Integer.parseInt(s);
		int sum = 0;
		
		while(i > 0) {
			sum = sum + (i % 10);
			i = i / 10;
		}
		
		System.out.println(sum);
	}

}
