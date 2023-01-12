##Approach 1: Using random library fxn shuffle
import random
from typing import List


class Solution:

    def __init__(self, nums: List[int]):
        self.original = nums[:]
        

    def reset(self) -> List[int]:
        return self.original

    def shuffle(self) -> List[int]:
        results = self.original[:]
        random.shuffle(results)
        return results


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()

##Approach 2: Bruteforce - Using an alternate array to randomly pop and replace the elements - time complexity: O(N^2), space complexity: O(N)

class Solution:

    def __init__(self, nums: List[int]):
        self.array = nums
        self.original = list(nums)
        

    def reset(self) -> List[int]:
        self.array = self.original
        self.original = list(self.original)
        return self.array

    def shuffle(self) -> List[int]:
        aux = list(self.array)
        
        for i in range(len(self.array)):
            remove_idx = random.randrange(len(aux))
            self.array[i] = aux.pop(remove_idx)
            
        return self.array


##Approach 3: Fisher-Yates algorithm - time complexity: O(N), space complexity: O(N)

class Solution:

    def __init__(self, nums: List[int]):
        self.array = nums
        self.original = list(nums)
        

    def reset(self) -> List[int]:
        self.array = self.original
        self.original = list(self.original)
        return self.array

    def shuffle(self) -> List[int]:
        aux = list(self.array)
        
        for i in range(len(self.array)):
            swap_idx = random.randrange(i, len(self.array))
            self.array[i], self.array[swap_idx] = self.array[swap_idx], self.array[i]
            
        return self.array


