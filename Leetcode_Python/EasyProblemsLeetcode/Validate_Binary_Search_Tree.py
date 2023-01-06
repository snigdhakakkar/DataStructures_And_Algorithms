## Iterative Traversal with valid range: O(N) time complexity, O(N) space complexity

import math
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SolutionII:
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

## Recursive Traversal with Valid Range: O(N) time complexity, O(N) space complexity
class SolutionI:

    def isValidBST(self, root: TreeNode) -> bool:
        
        def valid(node, left, right):
            if not node:
                return True
            
            if not (node.val < right and node.val > left):
                return False
            
            return (valid(node.left, left, node.val) and
            valid(node.right, node.val, right))
            
        return valid(root, float("-inf"), float("inf"))

