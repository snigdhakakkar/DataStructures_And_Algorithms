## There is an integer array nums sorted in ascending order (with distinct values).
# Prior to being passed to your function, nums is possibly rotated at an unknown pivot index 
# k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], 
# nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at 
# pivot index 3 and become [4,5,6,7,0,1,2].
# Given the array nums after the possible rotation and an integer target, 
# return the index of target if it is in nums, or -1 if it is not in nums.
# You must write an algorithm with O(log n) runtime complexity.

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        def find_rotate_index(left, right):
            if nums[left] < nums[right]:
                return 0
            
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] > nums[mid + 1]:
                    return mid + 1
                
                else:
                    if nums[mid] < nums[left]:
                        right = mid - 1
                    else: 
                        left = mid + 1
                        
        def search(left, right):
            while left <= right:
                pivot = (left + right) // 2
                if nums[pivot] == target:
                    return pivot
                else:
                    if target < nums[pivot]:
                        right = pivot - 1
                    else:
                        left = pivot + 1
            return -1
        
        length = len(nums)
        
        if length == 1:
            if nums[0] == target:
                return 0
            else:
                return -1
            
        rotateIndex = find_rotate_index(0, length - 1)
        
        ##if the target is the smallest element
        if target == nums[rotateIndex]:
            return rotateIndex
        
        ##if the array is not rotated, search in the entire array
        if rotateIndex == 0:
            return search(0, length-1)
        
        if target < nums[0]:
            ##search on the right side
            return search(rotateIndex, length-1)
        
        ## else search on the left side
        return search(0, rotateIndex)
            
##time complexity: O(logN), space complexity: O(1)