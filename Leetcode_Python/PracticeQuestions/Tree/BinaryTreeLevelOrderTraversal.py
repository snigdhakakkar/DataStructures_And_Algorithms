##Given the root of a binary tree, return the level order traversal of its nodes' values. 
# (i.e., from left to right, level by level).

# Definition for a binary tree node.
from typing import List
## Approach 1: Recursion - time complexity - O(N), space complexity - O(N)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        levels = []
        if not root:
            return levels
        
        def helper(node, level):
            #start at the present level
            if len(levels) == level:
                levels.append([])
                
            #append the current node value
            levels[level].append(node.val)
            
            #process child nodes for the next level
            if node.left:
                helper(node.left, level + 1)
            if node.right:
                helper(node.right, level + 1)
                
        helper(root, 0)
        return levels

##Approach 2: Iteration - 