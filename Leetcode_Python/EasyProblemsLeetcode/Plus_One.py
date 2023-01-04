from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        #method 1: type conversion
        return [int(x) for x in (str(int("".join([str(i) for i in digits])) + 1))]

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        #method 2: reverse order addition
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] == 9:
                digits[i] = 0
            else:
                digits[i] += 1
                return digits
        return [1] + digits