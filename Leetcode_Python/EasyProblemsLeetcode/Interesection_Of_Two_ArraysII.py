##Ask questions about the order of numbers in the array
##Ask how should I handle duplicates

## Approach 1: create a separate list to store the result. Check if each number in one list is there in the another, copy it to
## the result array, and remove it from list 2. 

from collections import Counter
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
## If only one of the lists, say nums2 cannot fit in the disk memory, then put all the elements of nums1 in hashMap. Read
## chunks of data of the array which fits in the memory and record the transactions.

## If it is the case that both the lists do not come in the memory, then sort them externally and compare two elements each at one time.

##Approach 2: Using counter object
## time complexity: O(n + m)
## space complexity: O(n)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        c = Counter(nums1)
        result = []
        
        for i in nums2:
            if c[i] > 0:
                result.append(i)
                c[i] -= 1
                
        return result