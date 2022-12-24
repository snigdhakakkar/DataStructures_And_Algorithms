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
