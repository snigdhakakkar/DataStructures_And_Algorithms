## Given the root of a binary tree, determine if it is a valid binary search tree (BST).
# A valid BST is defined as follows:
# The left subtree of a node contains only nodes with keys less than the node's key.
# The right subtree of a node contains only nodes with keys greater than the node's key.
# Both the left and right subtrees must also be binary search trees.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        def valid(node, left, right):
            if not node:
                return True
            
            if not (node.val <right and node.val > left):
                return False
            
            return (valid(node.left, left, node.val) and valid(node.right, node.val, right))
        
        return valid(root, float("-inf"), float("inf"))
            