from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #time complexity: n + klogn if we heapify
        #time complexity: nlogn if we use sorting
        #time complexity: O(n) as average time complexity if we use quick select; O(n^2) worst case
        ##QuickSelect approach
        k = len(nums) - k #index we are going to look at, as we are searching for kth largest element
        
        def quickSelect(l,r):
            pivot, p = nums[r], l
            for i in range(l,r):
                if nums[i] <= pivot:
                    nums[p], nums[i] = nums[i], nums[p]
                    p += 1
                    
            nums[p], nums[r] = pivot, nums[p]
            
            if k < p:
                return quickSelect(l, p-1)
            elif k > p:
                return quickSelect(p+1, r)
            else:
                return nums[p]
            
        return quickSelect(0, len(nums) - 1)