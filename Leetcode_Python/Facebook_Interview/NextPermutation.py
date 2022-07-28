## A permutation of an array of integers is an arrangement of its members into a sequence or 
# linear order.
# For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], 
# [3,1,2], [2,3,1]. The next permutation of an array of integers is the next 
# lexicographically greater permutation of its integer. More formally, if all the permutations 
# of the array are sorted in one container according to their lexicographical order, 
# then the next permutation of that array is the permutation that follows it in the sorted container. 
# If such arrangement is not possible, the array must be rearranged as the lowest possible order 
# (i.e., sorted in ascending order).
# For example, the next permutation of arr = [1,2,3] is [1,3,2].
# Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
# While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a 
# lexicographical larger rearrangement.
# Given an array of integers nums, find the next permutation of nums.
# The replacement must be in place and use only constant extra memory.

from typing import List


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        N = len(nums)
        pivot = 0
        
        #find a pivot
        for i in range(N-1, 0, -1):
            if nums[i - 1] < nums[i]:
                pivot = i
                break
        if pivot == 0:
            nums.sort()
            return
            
        
        #then find the swap which is the first number greater than the pivot
        swap = N - 1
        while nums[pivot-1] >= nums[swap]:
            swap -= 1
            
        #swap
        nums[swap], nums[pivot - 1] = nums[pivot - 1], nums[swap]
        
        #reverse from the pivot point all the way to the end
        nums[pivot:] = reversed(nums[pivot:])