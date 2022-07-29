## Given a file and assume that you can only read the file using a given method read4, 
# implement a method to read n characters.
# Method read4:
# The API read4 reads four consecutive characters from file, then writes those characters 
# into the buffer array buf4.
# 
# The return value is the number of actual characters read.
# Note that read4() has its own file pointer, much like FILE *fp in C.
# Definition of read4:
# Parameter:  char[] buf4
# Returns:    int
# buf4[] is a destination, not a source. The results from read4 will be copied to buf4[].
# Below is a high-level example of how read4 works:
# 
# File file("abcde"); // File is "abcde", initially file pointer (fp) points to 'a'
# char[] buf4 = new char[4]; // Create buffer with enough space to store characters
#
# read4(buf4); // read4 returns 4. Now buf4 = "abcd", fp points to 'e'
# read4(buf4); // read4 returns 1. Now buf4 = "e", fp points to end of file
# read4(buf4); // read4 returns 0. Now buf4 = "", fp points to end of file
 

# Method read:

# By using the read4 method, implement the method read that reads n characters from file and 
# store it in the buffer array buf. Consider that you cannot manipulate file directly.
# The return value is the number of actual characters read.
# Definition of read:
# Parameters:	char[] buf, int n
# Returns:	int

# buf[] is a destination, not a source. You will need to write the results to buf[].
# Note:

# Consider that you cannot manipulate the file directly. The file is only accessible for read4 
# but not for read.
# The read function will only be called once for each test case.
# You may assume the destination buffer array, buf, is guaranteed to have enough space for 
# storing n characters.

#Approach 1: Using internal buffer : time complexity: O(N), space complexity: O(1)

class Solution:
    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Number of characters to read (int)
        :rtype: The number of actual characters read (int)
        """
        copied_chars = 0
        read_chars = 4
        buf4 = [''] * 4
        
        while copied_chars < n and read_chars == 4:
            read_chars = read4(buf4)
            
            for i in range(read_chars):
                if copied_chars == n:
                    return copied_chars
                buf[copied_chars] = buf4[i]
                copied_chars += 1
                
        return copied_chars

## Approach 2:
class Solution:
    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Number of characters to read (int)
        :rtype: The number of actual characters read (int)
        """
        buf4 = ['']*4
        num_read = 0
        EOF = False
        
        while num_read < n and not EOF:
            curr_read = read4(buf4)
            delta = min(curr_read, n - num_read)
            buf[num_read: num_read + delta] = buf4[:delta]
            num_read += delta
            if curr_read < 4: 
                EOF = True
        return num_read