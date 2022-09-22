from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow, fast = 0, 0 #initialize the slow and fast pointers for Part 1: Floyd's algo
        while True:
            slow = nums[slow] #increment slow by 1 step
            fast = nums[nums[fast]] #increment fast by 2 steps
            if slow == fast: #if they meet at some point, then that's the collision point
                break

        """
        Suppose distance of the intersection point (duplicate number) from beginning is p nodes,
        and it's distance from the collision point (slow and fast) is x nodes
        and the length of cycle is c nodes
        thus, 2slow = fast
        2(p + c - x) = c + p + c - x 
        2p + 2c - 2x = 2c + p - x
        p = x
        i.e. distance of intersection point from the beginning is equal to the distance from 
        collision point
        """
            
        slow2 = 0 ##take this slow pointer at the beginning
        while True: 
            slow = nums[slow]
            slow2 = nums[slow2]
            if slow == slow2: #the intersection point would be the duplicate number / beginning of the loop
                break
                
        return slow