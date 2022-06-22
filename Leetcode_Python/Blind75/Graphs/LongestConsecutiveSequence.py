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

## Approach 2: sorting: time complexity - O(nlogn), space complexity - O(1) if sorted inpace; 
# O(n) if sorted in additional space

def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        nums.sort()
        
        longest_streak = 1
        current_streak = 1
        
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                if nums[i] == nums[i - 1] + 1:
                    current_streak += 1
                else:
                    longest_streak = max(longest_streak, current_streak)
                    current_streak = 1
                    
        return max(longest_streak, current_streak)

