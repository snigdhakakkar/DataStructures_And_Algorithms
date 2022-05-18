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
    
//Byte by byte with memoization
    
    /* The algorithm is documented as "reverse the bits in a byte with 3 operations" on the online book called Bit Twiddling Hacks by Sean Eron Anderson, where one can find more details.
    
    Algorithm

We iterate over the bytes of an integer. To retrieve the right-most byte in an integer, again we apply the bit AND operation (i.e. n & 0xff) with the bit mask of 11111111. 

For each byte, first we reverse the bits within the byte, via a function called reverseByte(byte). Then we shift the reversed bits to their final positions. 

With the function reverseByte(byte), we apply the technique of memoization, which caches the result of the function and returns the result directly for the future invocations of the same input.

def reverseByte(byte):
    return (byte * 0x0202020202 & 0x010884422010) % 1023
    
    */
    
    
    /* Time Complexity: O(1).; space complexity: O(1)
    */
    
    public int reverseByte(int byte, Map<int, int> cache) {
        if (cache.find(byte) != cache.end()) {
            return cache[byte];
        }
        
        int value = (byte * 0x0202020202 & 0x010884422010) % 1023;
        cache.emplace(byte, value);
        return value;
    }
    
    public int reverseBitsI(int n){
        int ret = 0, power = 24;
        Map<int, int> cache;
         while (n != 0) {
            ret += reverseByte(n & 0xff, cache) << power;
            n = n >> 8;
            power -= 8;
        }
        return ret;
    }
	
	

}
