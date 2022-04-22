package bitManipulation;

public class Q6ConversionApproach2 {
	
	public static void main(String[] args) {
		int a = -23432;
		int b = 512132;
		System.out.println(a + ": " + toFullBinaryString(a));
		System.out.println(b + ": " + toFullBinaryString(b));
		System.out.println("Required number of bits: " + bitSwapRequired(a, b));
	}
	
	public static String toFullBinaryString(int a) {
		String s = "";
		for (int i = 0; i < 32; i++) {
			Integer lsb = new Integer(a & 1);
			s = lsb.toString() + s;
			a = a >> 1;
		}
		return s;
	}
	
	public static int bitSwapRequired(int a, int b){
		int count = 0;
		int c = a ^ b;

		while (c != 0) {
			c = c & (c-1);
			count++;
		}
		return count;
	}
	

}
