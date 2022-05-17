package Top75;

/*
 * Problem statement - Write a function that takes an unsigned integer and returns the number of '1' bits it has 
 * (also known as the Hamming weight).
Note:Note that in some languages, such as Java, there is no unsigned integer type. 
In this case, the input will be given as a signed integer type. It should not affect your implementation, 
as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. 
Therefore, in Example 3, the input represents the signed integer. -3.
 */

public class Number_of_1_bits {
	
	 // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        //Approach 1: Loop and Flip
        
        /* We check each of the 32 bits of the number. If the bit is 1, we add one to the number of 1-bits. 
         * We can check the ith bit of a number using a bit mask. We start with a mask m=1, 
         * because the binary representation of 1 is,00000000000000000000000000000001. 
         * Clearly, a logical AND between any number and the mask 1 gives us the least significant bit of this number. 
         * To check the next bit, we shift the mask to the left by one.00000000000000000000000000000010, And so on.
        */
    	
    	/*time complexity: O(1) - The run time depends on the number of bits in n. Because n in this piece of 
    	code is a 32-bit integer, space complexity: O(1)*/
        
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        
        return bits;
    }
    
    public int hammingWeightII(int n) {
        
        //Approach 2: Bit Manipulation trick
            /* The key idea here is to realize that for any number n, doing a bit-wise AND of n and n−1 flips the least-significant 1-bit in n to 0. 
            */
            
            int sum = 0;
            while (n != 0) {
                sum++;
                n &= (n - 1);
            }
            return sum;
        }
        

}
