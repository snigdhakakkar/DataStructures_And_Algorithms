package Top75;

/*
 * Problem statement - Reverse bits of a given 32 bits unsigned integer.

Note:

Note that in some languages, such as Java, there is no unsigned integer type. 
In this case, both input and output will be given as a signed integer type. 
They should not affect your implementation, as the integer's internal binary 
representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. 
Therefore, in Example 2 above, the input represents the signed integer -3 and 
the output represents the signed integer -1073741825.

Follow up: If this function is called many times, how would you optimize it?
 */

public class reverse_bits {
	
    // you need treat n as an unsigned value
    
    /* Time Complexity: O(1). Though we have a loop in the algorithm, the number of iteration is fixed regardless the input, since the integer is of fixed-size (32-bits) in our problem. ; space complexity: O(1)
    */
    public int reverseBits(int n) {
        int ret = 0, power = 31;
        while (n != 0){
            ret += (n & 1) << power;
            n = n >> 1;
            power -= 1;
        }
        
        return ret;
    }
	
	

}
