##Ask questions about the order of numbers in the array
##Ask how should I handle duplicates

## Approach 1: create a separate list to store the result. Check if each number in one list is there in the another, copy it to
## the result array, and remove it from list 2. 

from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = []
        
        for i in nums1:
            if i in nums2:
                result.append(i)
                nums2.remove(i) #to handle duplicates
        return result

## What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
