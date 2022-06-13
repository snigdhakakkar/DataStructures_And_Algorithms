from typing import List
##Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
##You may assume that each input would have exactly one solution, and you may not use the same element twice.

##bruteforce approach
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if(nums[j] == target - nums[i]):
                    return [i,j]
##time complexity: O(n^2) and space complexity: O(1)

##Two-pass hashtable approach
    def twoSumI(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        
        for i in range(len(nums)):
            hashmap[nums[i]] = i
            
        for i in range(len(nums)):
            complement = target - nums[i]
            
            if complement in hashmap and hashmap[complement] != i:
                return [i, hashmap[complement]]
##time complexity: O(n) and space complexity: O(n)

##One-pass hashtable approach
    def twoSumII(self, nums: List[int], target: int) -> List[int]:
        hashmap ={}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hashmap:
                return [i, hashmap[complement]]
            hashmap[nums[i]] = i
##time complexity: O(n) and space complexity: O(n)
