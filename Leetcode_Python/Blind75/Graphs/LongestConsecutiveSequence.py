## Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
# You must write an algorithm that runs in O(n) time.

##Bruteforce approach: time complexity - O(n^3), space complexity - O(1)

from typing import List


def longestConsecutive(self, nums: List[int]) -> int:
        longest_streak = 0
        
        for num in nums:
            current_num = num
            current_streak = 1
            
            while current_num + 1 in nums:
                current_num += 1
                current_streak += 1
                
            longest_streak = max(longest_streak, current_streak)
            
        return longest_streak