## Given an integer array nums, return an array answer such that answer[i] is equal to the product 
# of all the elements of nums except nums[i]. The product of any prefix or suffix of nums 
# is guaranteed to fit in a 32-bit integer.
# You must write an algorithm that runs in O(n) time and without using the division operation.

# Example:
# Input: nums = [1,2,3,4]
# Output: [24,12,8,6]

from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        #the length of the input array
        length = len(nums)
        
        #left and right arrays of the ith value
        answer = [0]*length
        
        answer[0] = 1
        
        for i in range(1, length):
            answer[i] = nums[i - 1]*answer[i -1]
            
        #similarly, for right hand side product
        R = 1
        
        for i in reversed(range(length)):
            answer[i] = answer[i]*R
            R *= nums[i]
            
        return answer
        