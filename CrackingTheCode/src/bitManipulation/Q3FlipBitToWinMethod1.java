package bitManipulation;

public class Q3FlipBitToWinMethod1 {
	
	public static int SEQUENCE_LENGTH = 32;
	
	public static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}	
	
	public static int longestSequence(int n) {
		int maxSeq = 0;
		
		for (int i = 0; i < SEQUENCE_LENGTH; i++) {
			maxSeq = Math.max(maxSeq,  longestSequenceOf1s(n, i));
		}
		
		return maxSeq;
	}
	
	public static int longestSequenceOf1s(int n, int indexToIgnore) {
		int max = 0;
		int counter = 0;
		for (int i = 0; i < SEQUENCE_LENGTH; i++) {
			if (i == indexToIgnore || getBit(n, i)) {
				counter++;
				max = Math.max(counter, max);
			} else {
				counter = 0;
			}
		}
		return max;
	}	
	
	public static void main(String[] args) {
		int original_number = Integer.MAX_VALUE;
		int new_number = longestSequence(original_number);
		
		int number = 12;
		int new_number1 = longestSequence(number);
			
		System.out.println(Integer.toBinaryString(original_number));
		System.out.println(new_number);		
		
		System.out.println(Integer.toBinaryString(number));
		System.out.println(new_number1);
	}

}
