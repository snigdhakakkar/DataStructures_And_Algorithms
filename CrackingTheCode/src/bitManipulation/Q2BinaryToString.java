package bitManipulation;

public class Q2BinaryToString {
	
	/*0.101 in binary space = 1 * 1/ 2 + 0 * 1 / 2^2 + 1 * 1/2^3
	 * To print the decimal part, we can multiply by 2 and check if 2n is greater than or equal to 1. This is essentially shifting the fractional sum. 
	 * r = 2(in decimal space) * n = 2(in decimal space) * (0.101 in binary space) = 1 * 1/ 2^0 + 0 * 1 / 2^1 + 1 * 1/2^2 = 1.01 in binary space
	 * If r >= 1 , then we know that n had a 1 right after the decimal point. By doing this continuously we can check every digit.
	*/     
	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
	
	/*Rather than multiplying the number by 2 and then comparing it with 1, we can compare the number directly to 0.5, then 0.25, and so on
	 * 
	 */
	
	public static String printBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() >= 32) {
				return "ERROR";
			}
			if (num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}   
			frac /= 2;
		}
		return binary.toString();
	}
	
	
	public static void main(String[] args) {
		String bs = printBinary(.125);
		System.out.println(bs);
		
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = printBinary(num);
			String binary2 = printBinary2(num);
			if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
				System.out.println(num + " : " + binary + " " + binary2);
			}
		}
	}

}
