package array;

public class FindNoOfEvenDigits {
	static int findNumbers(int[] nums) {
        int counter = 0;
        for (int n: nums) {
            if (getDigits(n)%2 == 0) {
                counter++;
            }
        }
        return counter;
    }
    
    static int getDigits(int n) {
        int count = 0;
        while(n>0) {
            count++;
            n/=10;
        }
        return count;
    }
public static void main(String[] args) {
	int nums[] = {555,901,482,1771};
	System.out.println(findNumbers(nums));
}
}
