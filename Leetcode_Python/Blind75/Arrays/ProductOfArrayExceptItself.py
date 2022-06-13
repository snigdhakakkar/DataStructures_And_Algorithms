
##Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
# The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
# You must write an algorithm that runs in O(n) time and without using the division operation.

from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        #the length of the input array
        length = len(nums)
        
        #left and right arrays of the ith value
        L,R, answer = [0]*length, [0]*length, [0]*length
        
        #L[i] contains the product of all the elements to the left of the ith number in nums;
        #L[0] is 1 as there are no elements to its left
        L[0] = 1
        
        for i in range(1, length):
            L[i] = nums[i - 1]*L[i -1]
            
        #similarly, for right hand side product
        R[length - 1] = 1
        
        for i in reversed(range(length - 1)):
            R[i] = nums[i + 1]*R[i+1]
            
        ##constructing the answer array
        for i in range(length):
            answer[i] = L[i]*R[i]
            
        return answer

##time complexity: O(N), space complexity: O(N) used up by the two intermediate arrays that we constructed to keep track of product of elements to the left and right. 

