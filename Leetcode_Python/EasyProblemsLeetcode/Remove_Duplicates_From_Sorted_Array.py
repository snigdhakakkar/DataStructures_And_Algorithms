##time complexity: O(N)
##space complexity: O(1)


from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        insertIndex = 1
        for i in range(1, n):
            #if we find a unique element
            if nums[i - 1] != nums[i]:
                nums[insertIndex] = nums[i]
                #increment insertIndex
                insertIndex = insertIndex + 1
            
        #return insertIndex
        return insertIndex