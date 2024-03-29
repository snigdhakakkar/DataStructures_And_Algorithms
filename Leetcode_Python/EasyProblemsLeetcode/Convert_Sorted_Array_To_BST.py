# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
from typing import List


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        
        
        def helperfxn(l, r):
            if l > r:
                return None
            
            m = (l + r) // 2
            
            root = TreeNode(nums[m])
            root.left = helperfxn(l, m - 1)
            root.right = helperfxn(m + 1, r)
            return root
        
        return helperfxn(0, len(nums) - 1)