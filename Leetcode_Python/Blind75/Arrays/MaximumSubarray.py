## Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
# A subarray is a contiguous part of an array

import math
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_subArray_sum = -math.inf
        
        for i in range(len(nums)):
            current_subarray_sum = 0
            
            for j in range(i, len(nums)):
                current_subarray_sum += nums[j]
                max_subArray_sum = max(max_subArray_sum, current_subarray_sum)
                
        return max_subArray_sum

    #time complexity: O(n^2), space complexity: O(1)

## time complexity: O(n), space complexity: O(1)
    def maxSubArrayI(self, nums: List[int]) -> int:
        max_subArray_sum = current_subArray = nums[0]
        
        for num in nums[1:]:
            current_subArray = max(current_subArray + num, num)
            max_subArray_sum = max(max_subArray_sum, current_subArray)
                
        return max_subArray_sum


    def maxSubArray(self, nums: List[int]) -> int:
        def findBestSubarray(nums, left, right):
            # Base case - empty array.
            if left > right:
                return -math.inf

            mid = (left + right) // 2
            curr = best_left_sum = best_right_sum = 0

            # Iterate from the middle to the beginning.
            for i in range(mid - 1, left - 1, -1):
                curr += nums[i]
                best_left_sum = max(best_left_sum, curr)

            # Reset curr and iterate from the middle to the end.
            curr = 0
            for i in range(mid + 1, right + 1):
                curr += nums[i]
                best_right_sum = max(best_right_sum, curr)

            # The best_combined_sum uses the middle element and
            # the best possible sum from each half.
            best_combined_sum = nums[mid] + best_left_sum + best_right_sum

            # Find the best subarray possible from both halves.
            left_half = findBestSubarray(nums, left, mid - 1)
            right_half = findBestSubarray(nums, mid + 1, right)

            # The largest of the 3 is the answer for any given input array.
            return max(best_combined_sum, left_half, right_half)
        
        # Our helper function is designed to solve this problem for
        # any array - so just call it using the entire input!
        return findBestSubarray(nums, 0, len(nums) - 1)
##divide and conquer approach: time complexity - O(NlogN), space complexity: O(logN)

    