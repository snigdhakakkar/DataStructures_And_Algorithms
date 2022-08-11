## A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the 
# sequence has an edge connecting them. A node can only appear in the sequence at most once. 
# Note that the path does not need to pass through the root.
# The path sum of a path is the sum of the node's values in the path.
# Given the root of a binary tree, return the maximum path sum of any non-empty path.

# Example:
# Input: root = [-10,9,20,null,null,15,7] Output: 42
# Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        res = [root.val] ##global variable - it's taken as a list to make it's edit easier
        ##return the max path sum without split
        def dfs(root):
            if not root: ##when no root node, return zero
                return 0
            
            leftMax = dfs(root.left) 
            rightMax = dfs(root.right)
            leftMax = max(leftMax, 0) ##handling negative cases
            rightMax = max(rightMax, 0) ##handling negative cases
            
            #compute max path sum with split
            res[0] = max(res[0], root.val + leftMax + rightMax)
            
            return root.val + max(leftMax, rightMax)
        
        dfs(root)
        return res[0]
        