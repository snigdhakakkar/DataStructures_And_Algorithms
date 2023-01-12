##Using random library fxn shuffle
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