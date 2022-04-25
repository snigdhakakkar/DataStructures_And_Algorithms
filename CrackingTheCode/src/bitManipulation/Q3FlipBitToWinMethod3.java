package bitManipulation;

public class Q3FlipBitToWinMethod3 {
	
	public static int flipBit(int a) {
		/* If all 1s, this is already the longest sequence. */
		if (~a == 0) return Integer.BYTES * 8;
		
		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1; // We can always have a sequence of at least one 1
		while (a != 0) {
			if ((a & 1) == 1) {
				currentLength++;
			} else if ((a & 1) == 0) {
				/* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
				previousLength = (a & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			}
			maxLength = Math.max(previousLength + currentLength + 1, maxLength);
			a >>>= 1;
		}     
		return maxLength;
	}
	
	public static void main(String[] args) {
		int original_number = Integer.MAX_VALUE;
		int new_number = flipBit(original_number);
		
		int number = 12;
		int new_number1 = flipBit(number);
			
		System.out.println(Integer.toBinaryString(original_number));
		System.out.println(new_number);		
		
		System.out.println(Integer.toBinaryString(number));
		System.out.println(new_number1);
	}


}
