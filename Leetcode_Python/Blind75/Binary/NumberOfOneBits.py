## Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
# Note:
# Note that in some languages, such as Java, there is no unsigned integer type. In this case, 
# the input will be given as a signed integer type. It should not affect your implementation, 
# as the integer's internal binary representation is the same, whether it is signed or unsigned.
# In Java, the compiler represents the signed integers using 2's complement notation. 
# Therefore, in Example 3, the input represents the signed integer. -3

from typing_extensions import Self


def hammingWeight(self, n: int) -> int:
        # convert given number into binary
        # output will be like bin(11)=0b1101
        binary = bin(n)
        
        # now separate out all 1's from binary string
        # we need to skip starting two characters
        # of binary string i.e; 0b
        setBits = [ones for ones in binary[2:] if ones =="1"] 
        
        return len(setBits)

# Driver program
if __name__ == "__main__":
    n = 11
    print(hammingWeight(Self,n))

##another approch
num = 11
print (bin(num).count("1"))

##another approach
def hammingWeightI(self, n: int) -> int:
        
        # base case
        if (n == 0):
            return 0
        
        else:
            # if last bit set add 1 else
            # add 0
            count = 0
            while(n):
                count += n & 1
                n >>= 1
            return count