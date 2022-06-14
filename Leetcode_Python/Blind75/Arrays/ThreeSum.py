##Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
# such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
# Notice that the solution set must not contain duplicate triplets.

## Two pointer approach: time complexity: O(N^2) space complexity: ranges from O(logN) to O(N) 
# depending upon the sorting algorithm used

from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        
        for i in range(len(nums)):
            if nums[i] > 0:
                break
            if i == 0 or nums[i - 1] != nums[i]:
                self.twoSum(nums, i, result)
                
        return result
    
    def twoSum(self, nums: List[int], i: int, result: List[List[int]]):
        low, high = i+1, len(nums) - 1
        while(low < high):
            sum = nums[i] + nums[low] + nums[high]
            
            if sum < 0:
                low += 1
            elif sum > 0:
                high -= 1
                
            else:
                result.append([nums[i], nums[low], nums[high]])
                low += 1
                high -= 1
                while low < high and nums[low] == nums[low - 1]:
                    low += 1

    ##using hashset: time complexity: O(N^2), Space complexity: O(N) as it uses hashSet
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        
        for i in range(len(nums)):
            if nums[i] > 0:
                break
            if i == 0 or nums[i - 1] != nums[i]:
                self.twoSum(nums, i, result)
        return result
    
    def twoSum(self, nums: List[int], i: int, result: List[List[int]]):
        seen = set()
        j = i+1
        while j < len(nums):
            complement = -nums[i] -nums[j]
            if complement in seen:
                result.append([nums[i], nums[j], complement])
                while j+1< len(nums) and nums[j] == nums[j+1]:
                    j +=1
            seen.add(nums[j])
            j += 1
## using hashmap for seen and without sorting the actual List: time complexity-O(N^2), space complexity: O(N)
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res, dups = set(), set()
        seen = {}
        for i, val1 in enumerate(nums):
            if val1 not in dups:
                dups.add(val1)
                for j, val2 in enumerate(nums[i+1:]):
                    complement = -val1 - val2
                    if complement in seen and seen[complement] == i:
                        res.add(tuple(sorted((val1, val2, complement))))
                    seen[val2] = i
        return res