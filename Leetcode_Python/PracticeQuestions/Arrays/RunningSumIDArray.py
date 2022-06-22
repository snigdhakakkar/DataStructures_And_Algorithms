from typing import List

##Approach 1: using additional output array
def runningSum(self, nums: List[int]) -> List[int]:
        
        output = [0]*len(nums)
        output[0] = nums[0]
        for i in range(1, len(nums)):
            output[i] = output[i - 1] + nums[i]
            
        return output
## Approach 2: modifying input array for output
def runningSum(self, nums: List[int]) -> List[int]:
        
        for i in range(1, len(nums)):
            nums[i] += nums[i - 1]
            
        return nums
            