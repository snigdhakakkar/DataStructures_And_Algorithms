package Top75;

/*
 * Problem statement - Given two integers a and b, return the sum of the two integers 
 * without using the operators + and -.
 */

/*
 * First of all, there are too many use cases here: both a and b could be positive or negative,
 * abs(a) could be greater than or less than abs(b), in total, that results in 2X2X2 = 8 use cases
 * 
 * Let us start by reducing the problem down to two simple use cases -
 * Sum of two positive integers: x+ y, where x > y
 * Difference of two positive integers: x - y, where x > y
 */
public class SumOfTwoIntegers {
	
	public int getSum(int a, int b) {
        /* the sum of two positive integers. Here XOR is a key as well because it's a sum of two integers in the binary form without taking carry into account. In other words, XOR is a sum of bits of x and y where at least one of the bits is not set.
        */
        
        /*The next step is to find the carry. It contains the common set bits of x and y, shifted one bit to the left. i.e. it's logical AND of two input numbers, shifted one bit to the left: 
carry=(x&y)<<1.
        */
        
        /* As for addition, XOR is a difference of two integers without taking borrow into account.
        The next step is to find the borrow. It contains common set bits of y and unset bits of x, i.e.
borrow=((∼x)&y)<<1.
        */
        
        /* The problem is reduced down to the subtraction of the borrow from the answer without borrow. As for the sum, it could be solved recursively or in a loop with the condition statement "while borrow is not equal to zero".*/
        
        int x = Math.abs(a), y = Math.abs(b);
        // ensure that abs(a) >= abs(b)
        if (x < y) return getSum(b, a);
        
        // abs(a) >= abs(b) --> 
        // a determines the sign
        int sign = a > 0 ? 1 : -1;
        
        if (a * b >= 0) {
            //sum of two positive integers
            //where x > y
            while (y != 0) {
                int answer = x ^ y;
                int carry = (x&y) << 1;
                x = answer;
                y = carry;
            }
        } else {
            //difference of two positive integers = x - y
            //where x > y
            while (y != 0) {
                int answer = x^y;
                int borrow = ((~x) & y)<<1;
                x = answer;
                y = borrow;
            }
        }
        
        return x * sign;
    
    }
}

//time complexity: O(1)  because each integer contains 32 bits. space complexity: O(1)
	

}
