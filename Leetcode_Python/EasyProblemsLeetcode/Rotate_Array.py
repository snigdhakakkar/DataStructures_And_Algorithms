##Approach 1: By placing each element at its correct location (moved by 1 step at a time):
    #time complexity: O(nk)
    #space complexity: O(1)

from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        
        for i in range(k):
            previous = nums[-1]
            for j in range(len(nums)):
                nums[j], previous = previous, nums[j]

##Approach 2: Reverse the entire array first --> then reverse until the k elements and the remaining portion separately

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        l, r = 0, len(nums) - 1
        
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l, r = l+1, r-1
            
        l, r = 0, k - 1
        
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l, r = l+1, r-1
            
        l, r = k, len(nums) - 1
        
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l, r = l+1, r-1
