from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        #method 1: type conversion
        return [int(x) for x in (str(int("".join([str(i) for i in digits])) + 1))]