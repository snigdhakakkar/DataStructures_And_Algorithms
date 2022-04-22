package bitManipulation;

public class Q5Debugger {
	
	/*
	 * What does ((n & (n-1)) == 0 mean?
	 * Let us start backwards: What does A & B == 0 mean --> it means A and b never have a 1 bit in the same place. So, if n & (n-1) == 0 then n and n-1 never share a 1.
	 * What does n-1 look like when compared to n?
	 * Try subtracting one from a number and we see that we look at the least significant bit.
	 * If that bit is 1, we change it to 0 but if it is 0 we must borrow from a larger bit. So, we go to the larger bits, changing each bit from a 0 to a 1, until we find a 1 which we flip to 0.
	 * Thus, if n is abcde1000; then n-1 is abcde0111
	 * So what does n & (n - 1) == 0 indicate?
	 * n and n - 1 must not have a 1 bit in common. This can happen when abcde are all 0s, which means n looks like 000001000 and n - 1 is 000000111. This shows that the value n is a power of 2.
	 * So, (n & (n - 1)) == 0 checks if n is a power of 2 or not.
	 */

}
