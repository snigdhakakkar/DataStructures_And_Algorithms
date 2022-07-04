##Given the root of a binary tree, determine if it is a valid binary search tree (BST).
# A valid BST is defined as follows:
# The left subtree of a node contains only nodes with keys less than the node's key
# The right subtree of a node contains only nodes with keys greater than the node's key
# Both the left and right subtrees must also be binary search trees.

##Approach 1: Recursive Traversal with Valid Range - time complexity: O(N), space complexity: O(N)
# Definition for a binary tree node.
import math


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        def validate(node, low = -math.inf, high = math.inf):
            ##empty tree is a valid BST
            if not node:
                return True
            
            ##current node's value must be between low and high
            if node.val <= low or node.val >= high:
                return False
            
            #left and right subtree must also be valid
            return (validate(node.right, node.val, high) and
                   validate(node.left, low, node.val))
        
        return validate(root)

##Approach 2: Iterative traversal with a valid range- time complexity: O(N), space complexity: O(N)

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        if not root:
            return True
        
        stack = [(root, -math.inf, math.inf)]
        while stack:
            root, lower, upper = stack.pop()
            if not root:
                continue
            val = root.val
            if val <= lower or val >= upper:
                return False
            stack.append((root.right, val, upper))
            stack.append((root.left, lower, val))
            
        return True